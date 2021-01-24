package com.example.shoestore.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentIntroOnboardingBinding

class IntroOnboardingFragment : Fragment() {

    private lateinit var binding : FragmentIntroOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.title = "Instructions (1/2)"

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_intro_onboarding,container,false)

        return binding.root

    }

}