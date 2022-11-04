package com.example.shoestoreinvetoryapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shoestoreinvetoryapp.R
import com.example.shoestoreinvetoryapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater,
             R.layout.fragment_login, container, false)

        // New Login button navigate to the Welcome Screen
        binding.btnNewLogin.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        // Existing Login button navigate to the Welcome Screen
        binding.btnExistingLogin.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}