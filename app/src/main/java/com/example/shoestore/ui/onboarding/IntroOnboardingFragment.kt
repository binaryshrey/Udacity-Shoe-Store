package com.example.shoestore.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentIntroOnboardingBinding
import com.example.shoestore.viewmodel.ShoeViewModel

class IntroOnboardingFragment : Fragment() {

    private lateinit var binding : FragmentIntroOnboardingBinding
    private lateinit var viewModel : ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.title = "Instructions (1/2)"

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_intro_onboarding,container,false)

        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        binding.lifecycleOwner = this
        binding.shoeViewModel = viewModel

        //observe intro-event
        viewModel.eventIntro.observe(viewLifecycleOwner, {introNextClicked ->
            if(introNextClicked){
                //navigate to outro-onboarding fragment
                findNavController().navigate(IntroOnboardingFragmentDirections.actionIntroOnboardingFragmentToOutroOnboardingFragment())
                viewModel.onIntroComplete()
            }
        })

        return binding.root
    }

}