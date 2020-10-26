package br.com.muniz.shoestore.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import br.com.muniz.shoestore.R
import br.com.muniz.shoestore.databinding.FragmentShoeListBinding
import br.com.muniz.shoestore.databinding.ShoeItemListLayoutBinding
import br.com.muniz.shoestore.viewModel.ShoeListViewModel

class ShoeList : Fragment() {

    private lateinit var binding: FragmentShoeListBinding

    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )

        binding.lifecycleOwner = this
        binding.shoeList = this
        binding.viewModel = viewModel

        // a observer to create populate the scrollview in any change
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { newShoe ->

            for (i in 0 until newShoe.size) {
                val shoeBinding = DataBindingUtil.inflate<ShoeItemListLayoutBinding>(
                    inflater, R.layout.shoe_item_list_layout, container, false
                )
                shoeBinding.shoeItem = newShoe[i]
                binding.shoeListLayout.addView(shoeBinding.root)
            }
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    // Navigate to Detail Fragment passing a shoe in safe args
    fun goToDetailFragment() {
            findNavController().navigate(ShoeListDirections.actionShoeListToShoeDetails())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}