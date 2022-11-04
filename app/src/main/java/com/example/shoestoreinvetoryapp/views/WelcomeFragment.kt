package com.example.shoestoreinvetoryapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestoreinvetoryapp.R
import com.example.shoestoreinvetoryapp.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentWelcomeBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_welcome, container, false)

        binding.btnProceed.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment())
        }

        return binding.root

    }

}