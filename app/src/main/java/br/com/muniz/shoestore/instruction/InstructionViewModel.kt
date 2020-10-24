package br.com.muniz.shoestore.instruction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionViewModel : ViewModel() {

    private val _instructionState = MutableLiveData<Boolean>()
    val instructionState: LiveData<Boolean>
        get() = _instructionState

    init {
        _instructionState.value = false
    }

    fun onClickConfirmInstruction(){
        _instructionState.value = true
    }

}