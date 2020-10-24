package br.com.muniz.shoestore.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {

    private val _welcomeState = MutableLiveData<Boolean>()
    val welcomeState: LiveData<Boolean>
        get() = _welcomeState

    init {
        _welcomeState.value = false
    }

    fun onClickCheckout(){
        _welcomeState.value = true
    }
}