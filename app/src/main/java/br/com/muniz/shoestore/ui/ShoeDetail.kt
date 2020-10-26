package br.com.muniz.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import br.com.muniz.shoestore.R
import br.com.muniz.shoestore.databinding.FragmentShoeDetailsBinding
import br.com.muniz.shoestore.models.Shoe
import br.com.muniz.shoestore.viewModel.ShoeListViewModel

class ShoeDetail : BaseFragment() {

    private lateinit var binding: FragmentShoeDetailsBinding

    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)

        binding.lifecycleOwner = this
        binding.details = this
        binding.newShoe = Shoe("", 0.0, "", "")

        return binding.root
    }

    fun addShoe() {
        viewModel.addShoe(binding.newShoe)
        navController.navigateUp()
    }

    fun cancel() {
        navController.navigateUp()
    }

}