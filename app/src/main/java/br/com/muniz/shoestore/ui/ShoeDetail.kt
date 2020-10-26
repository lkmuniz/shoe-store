package br.com.muniz.shoestore.shoeDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.muniz.shoestore.R
import br.com.muniz.shoestore.databinding.FragmentShoeDetailsBinding

class ShoeDetail : Fragment() {


    private lateinit var binding: FragmentShoeDetailsBinding
    private lateinit var viewModel: ShoeDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)

        viewModel = ViewModelProvider(this).get(ShoeDetailViewModel::class.java)
        binding.detailViewModel = viewModel

        return binding.root
    }

}