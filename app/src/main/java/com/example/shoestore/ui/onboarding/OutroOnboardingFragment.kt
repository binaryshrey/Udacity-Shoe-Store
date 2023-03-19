package com.example.shoestore.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentOutroOnboardingBinding
import com.example.shoestore.viewmodel.ShoeViewModel

class OutroOnboardingFragment : Fragment() {

    private lateinit var binding : FragmentOutroOnboardingBinding
    private lateinit var viewModel : ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.title = "Instructions (2/2)"

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_outro_onboarding,container,false)
        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        binding.lifecycleOwner = this
        binding.shoeViewModel = viewModel

        //observe opening of shoeList fragment
        viewModel.eventOpenShoeList.observe(viewLifecycleOwner) { outroDoneClicked ->
            if (outroDoneClicked) {
                //navigate to shoe List fragmnet
                findNavController().navigate(OutroOnboardingFragmentDirections.actionOutroOnboardingFragmentToShoeListFragment())
                viewModel.onOpenShoeListComplete()
            }
        }

        return binding.root
    }

}