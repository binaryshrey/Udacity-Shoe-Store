package com.example.shoestore.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentIntroOnboardingBinding
import com.example.shoestore.databinding.FragmentOutroOnboardingBinding

class OutroOnboardingFragment : Fragment() {

    private lateinit var binding : FragmentOutroOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.title = "Instructions (2/2)"

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_outro_onboarding,container,false)

        binding.finishButton.setOnClickListener { view : View ->
            view.findNavController().navigate(OutroOnboardingFragmentDirections.actionOutroOnboardingFragmentToShoeListFragment())
        }

        return binding.root
    }

}