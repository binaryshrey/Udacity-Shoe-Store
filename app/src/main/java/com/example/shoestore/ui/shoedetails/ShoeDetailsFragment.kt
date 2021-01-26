package com.example.shoestore.ui.shoedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoeDetailsBinding
import com.example.shoestore.model.Shoe
import com.example.shoestore.viewmodel.ShoeViewModel

class ShoeDetailsFragment : Fragment() {

    private lateinit var binding : FragmentShoeDetailsBinding
    private val viewModel : ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.title = "Add Shoe"

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_details,container,false)

        binding.lifecycleOwner = this
        binding.shoeViewModel = viewModel
        binding.shoes = Shoe()

        //observe save event
        viewModel.eventSave.observe(viewLifecycleOwner, {isSaved ->
            if(isSaved){
                //navigate to shoelist fragment
                findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
                viewModel.onEventSaveCompleted()
            }
        })

        //observe cancel event
        viewModel.eventCancel.observe(viewLifecycleOwner,{ isCanceled ->
            if(isCanceled){
                //navigate to shoelist fragment
                findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
                viewModel.onEventCancelCompleted()
            }
        })

        return binding.root
    }

}