package com.example.shoestoreinvetoryapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestoreinvetoryapp.R
import com.example.shoestoreinvetoryapp.databinding.FragmentShoeDetailBinding
import com.example.shoestoreinvetoryapp.viewmodels.ShoeListViewModel

class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_detail, container, false)

        //viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        binding.shoeDetailViewModel = viewModel
        binding.lifecycleOwner = this

        binding.btnCancel.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        findNavController().popBackStack(R.id.shoeDetailFragment, false)

        binding.btnSave.setOnClickListener {
            val newShoeName = binding.editShoeName.text.toString()
            val newCompany = binding.editShoeCompany.text.toString()
            val newDescription = binding.editShoeDescription.text.toString()
            val newSize = binding.editShoeSize.text.toString()

            if(newShoeName.isEmpty() || newCompany.isEmpty() || newDescription.isEmpty() || newSize.isEmpty()){
                Toast.makeText(requireActivity(), "All fields are required!", Toast.LENGTH_SHORT).show()
            }
            else {
                viewModel.addMyShoe()
                Toast.makeText(requireActivity(), "Successfully Added!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
            }
        }

        return binding.root
    }

}