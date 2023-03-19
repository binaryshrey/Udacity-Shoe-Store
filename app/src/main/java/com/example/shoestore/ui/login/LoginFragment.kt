package com.example.shoestore.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestore.MainActivity
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentLoginBinding
import com.example.shoestore.viewmodel.ShoeViewModel

class LoginFragment : Fragment() {

    private lateinit var binding : FragmentLoginBinding
    private val viewModel : ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        (activity as AppCompatActivity).supportActionBar?.title = "Shoe Store"

        binding.lifecycleOwner = this
        binding.shoeViewModel = viewModel

        //observe login-event
        viewModel.eventLogin.observe(viewLifecycleOwner) { isLoggedIn ->
            if (isLoggedIn) {
                //call storeLoginState from viewmodel to store it in sharedPreferences
                viewModel.storeLoginState(activity as MainActivity, true)
                viewModel.onLoginComplete()
                //navigate to intro-fragment
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToIntroOnboardingFragment())
            }
        }
        return binding.root
    }

}