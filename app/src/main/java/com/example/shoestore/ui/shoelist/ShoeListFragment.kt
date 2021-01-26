package com.example.shoestore.ui.shoelist

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoeListBinding
import com.example.shoestore.databinding.ShoeListItemBinding
import com.example.shoestore.viewmodel.ShoeViewModel

class ShoeListFragment : Fragment() {

    private lateinit var binding : FragmentShoeListBinding
    private val viewModel : ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list,container,false)
        (activity as AppCompatActivity).supportActionBar?.title = "Shoe Store"
        setHasOptionsMenu(true)


        binding.lifecycleOwner = this
        binding.shoeViewModel = viewModel

        //add views to shoeList
        //https://stackoverflow.com/questions/2395769/how-to-programmatically-add-views-to-views
        viewModel.shoes.observe(viewLifecycleOwner, {shoes ->
            binding.shoeItemList.removeAllViews()
            shoes.forEach { shoe ->
                val shoeBinding : ShoeListItemBinding = DataBindingUtil.inflate(inflater,R.layout.shoe_list_item,container,false)
                shoeBinding.shoes = shoe
                shoeBinding.executePendingBindings()
                binding.shoeItemList.addView(shoeBinding.root)
            }
        } )

        //observe adding to shoeDetails event
        viewModel.eventAddShoeDetails.observe(viewLifecycleOwner,{ onAddShoeClicked ->
            if(onAddShoeClicked){
                //navigate to shoe details fragment
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
                viewModel.onAddShoeDetailsComplete()
            }
        })
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

}