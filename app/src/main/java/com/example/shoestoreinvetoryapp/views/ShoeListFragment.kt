package com.example.shoestoreinvetoryapp.views

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestoreinvetoryapp.R
import com.example.shoestoreinvetoryapp.databinding.FragmentShoeListBinding
import com.example.shoestoreinvetoryapp.databinding.ItemShoeBinding
import com.example.shoestoreinvetoryapp.viewmodels.ShoeListViewModel

class ShoeListFragment : Fragment() {
    private val viewModel: ShoeListViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(inflater,
                    R.layout.fragment_shoe_list, container, false)

        // Get the ViewModel
        //viewModel = ViewModelProvider(requireActivity())[ShoeListViewModel::class.java]
        binding.shoeListViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.listOfShoes.observe(viewLifecycleOwner) {
            binding.linearLayoutShoeList.removeAllViews()

            for(Shoe in it){
                val bindingItem: ItemShoeBinding = DataBindingUtil.inflate(layoutInflater,
                    R.layout.item_shoe, container,false)

                bindingItem.shoeTitle.text = Shoe.name
                bindingItem.shoeSize.text = "Size: ${Shoe.size}"
                bindingItem.shoeCompany.text = "Company: ${Shoe.company}"
                bindingItem.shoeDescription.text = Shoe.description

                binding.linearLayoutShoeList.addView(bindingItem.root)

            }
        }

        findNavController().popBackStack(R.id.shoeListFragment, false)

        binding.floatAddShoe.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_shoe_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> logOut()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun logOut() {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
    }
}