package com.example.shoestore.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding : FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        (activity as AppCompatActivity).supportActionBar?.title = "Shoe Store"


        binding.loginButton.setOnClickListener { view : View ->
            //Toast.makeText(context,"Login",Toast.LENGTH_SHORT).show()
            view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToIntroOnboardingFragment())

        }
        binding.signupButton.setOnClickListener { view : View ->
            //Toast.makeText(context,"Sign Up",Toast.LENGTH_SHORT).show()
            view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToIntroOnboardingFragment())

        }

        return binding.root
    }

}