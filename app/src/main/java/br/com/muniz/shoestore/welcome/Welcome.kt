package br.com.muniz.shoestore.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import br.com.muniz.shoestore.R
import br.com.muniz.shoestore.databinding.FragmentWelcomeBinding


class Welcome : Fragment() {

    private lateinit var viewModel: WelcomeViewModel

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_welcome, container, false
        )

        viewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)
        viewModel.welcomeState.observe(viewLifecycleOwner, Observer { newState ->
            if (newState)
                goToInstruction()
        })
        binding.welcomeViewModel = viewModel


        return binding.root
    }

    // Navigates to instruction fragment
    fun goToInstruction() {
        findNavController().navigate(R.id.action_welcome_to_instruction)
    }

}