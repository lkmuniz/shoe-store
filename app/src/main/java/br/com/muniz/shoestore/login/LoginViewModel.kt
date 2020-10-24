package br.com.muniz.shoestore.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private const val IS_LOGGED = true

class LoginViewModel : ViewModel() {


    private val _loginState = MutableLiveData<Boolean>()
    val loginState: LiveData<Boolean>
        get() = _loginState

    init {
        _loginState.value = false
    }

    // In this case the login and create account button go to the same fragment
    fun onClickLogin() {
        _loginState.value = IS_LOGGED
    }

    // For further implementation
    fun onClickCreateAccount() {
        _loginState.value = IS_LOGGED
    }
}