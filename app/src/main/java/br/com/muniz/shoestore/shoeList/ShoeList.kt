package br.com.muniz.shoestore.shoeList

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import br.com.muniz.shoestore.R
import br.com.muniz.shoestore.databinding.FragmentShoeListBinding
import br.com.muniz.shoestore.databinding.ShoeItemListLayoutBinding
import br.com.muniz.shoestore.models.Shoe

class ShoeList : Fragment() {

    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShoeListBinding>(
            inflater, R.layout.fragment_shoe_list, container, false
        )

        // get the viewModel from ViewModelProvider
        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        // a observer to create populate the scrollview in any change
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { newShoe ->
            newShoe.forEach {
                var newShoeLayout = DataBindingUtil.inflate<ShoeItemListLayoutBinding>(
                    inflater, R.layout.shoe_item_list_layout, binding.shoeItemLayout, false
                )
                newShoeLayout.shoeItem = it
                binding.shoeItemLayout.addView(newShoeLayout.root)
            }
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    // Navigate to Detail Fragment passing a shoe in safe args
    private fun goToDetailFragment(shoe: Shoe) {
            findNavController().navigate(ShoeListDirections.actionShoeListToShoeDetails(shoe))
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