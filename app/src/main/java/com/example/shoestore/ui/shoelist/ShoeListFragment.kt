package com.example.shoestore.ui.shoelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        binding.lifecycleOwner = this
        binding.shoeViewModel = viewModel

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

        viewModel.eventAddShoeDetails.observe(viewLifecycleOwner,{ onAddShoeClicked ->
            if(onAddShoeClicked){
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
                viewModel.onAddShoeDetailsComplete()
            }
        })

        binding.addButton.setOnClickListener { view : View ->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
        }

        return binding.root
    }

}