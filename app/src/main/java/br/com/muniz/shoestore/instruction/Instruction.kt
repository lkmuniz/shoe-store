package br.com.muniz.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import br.com.muniz.shoestore.databinding.FragmentInstructionBinding

class Instruction : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentInstructionBinding>(
            inflater, R.layout.fragment_instruction, container, false
        )

        binding.buttonConfirmInstruction.setOnClickListener {
            goToShoeList()
        }

        return binding.root
    }

    private fun goToShoeList() {
        findNavController().navigate(R.id.action_instruction_to_shoeList)
    }

}