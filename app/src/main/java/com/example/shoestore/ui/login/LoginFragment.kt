package com.example.shoestore.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
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

        binding.loginButton.setOnClickListener {
            Toast.makeText(context,"Login",Toast.LENGTH_SHORT).show()
        }
        binding.signupButton.setOnClickListener {
            Toast.makeText(context,"Sign Up",Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

}