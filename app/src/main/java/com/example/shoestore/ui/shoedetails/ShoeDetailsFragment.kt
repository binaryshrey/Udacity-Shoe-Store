package com.example.shoestore.ui.shoedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoeDetailsBinding

class ShoeDetailsFragment : Fragment() {

    private lateinit var binding : FragmentShoeDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.title = "Add Shoe"

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_details,container,false)

        binding.saveButton.setOnClickListener { view : View ->
            Toast.makeText(context,"Saved",Toast.LENGTH_SHORT).show()
            view.findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
        }
        binding.cancelButton.setOnClickListener { view : View ->
            Toast.makeText(context,"Cancel",Toast.LENGTH_SHORT).show()
            view.findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())

        }

        return binding.root
    }

}