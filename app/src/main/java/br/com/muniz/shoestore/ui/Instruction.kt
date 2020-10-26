package br.com.muniz.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import br.com.muniz.shoestore.R
import br.com.muniz.shoestore.databinding.FragmentInstructionBinding

class Instruction : Fragment() {

    private lateinit var binding: FragmentInstructionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate and binding the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_instruction, container, false
        )

        binding.lifecycleOwner = this
        binding.instruction = this

        return binding.root
    }

    // Navigate to ShoeList Fragment
    fun goToShoeList() {
        findNavController().navigate(R.id.action_instruction_to_shoeList)
    }

}