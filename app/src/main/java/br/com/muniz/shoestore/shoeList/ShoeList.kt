package br.com.muniz.shoestore.shoeList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.muniz.shoestore.R
import br.com.muniz.shoestore.databinding.FragmentShoeListBinding
import kotlinx.android.synthetic.main.shoe_item_list_layout.view.*

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
                var view = View.inflate(context, R.layout.shoe_item_list_layout, null)
                view.shoe_item_name.text = it.name
                view.shoe_item_company.text = it.company
                view.shoe_item_size.text = it.size.toString()
                binding.shoeItemLayout.addView(view)
            }
        })

        return binding.root
    }

}