package br.com.muniz.shoestore.instruction

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
import br.com.muniz.shoestore.databinding.FragmentInstructionBinding

class Instruction : Fragment() {

    private lateinit var viewModel: InstructionViewModel

    private lateinit var binding: FragmentInstructionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentInstructionBinding>(
            inflater, R.layout.fragment_instruction, container, false
        )

        viewModel = ViewModelProvider(this).get(InstructionViewModel::class.java)
        binding.instructionViewModel = viewModel

        viewModel.instructionState.observe(viewLifecycleOwner, Observer { newState ->
            if (newState)
                goToShoeList()
        })

        binding.buttonConfirmInstruction.setOnClickListener {
            goToShoeList()
        }

        return binding.root
    }

    private fun goToShoeList() {
        findNavController().navigate(R.id.action_instruction_to_shoeList)
    }

}