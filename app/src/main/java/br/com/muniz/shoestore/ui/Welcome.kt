package br.com.muniz.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import br.com.muniz.shoestore.R
import br.com.muniz.shoestore.databinding.FragmentWelcomeBinding


class Welcome : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_welcome, container, false
        )

        binding.lifecycleOwner = this
        binding.welcome = this

        return binding.root
    }

    // Navigates to instruction fragment
    fun goToInstruction() {
        findNavController().navigate(R.id.action_welcome_to_instruction)
    }

}