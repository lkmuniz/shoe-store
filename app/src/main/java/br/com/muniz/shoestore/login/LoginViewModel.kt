package br.com.muniz.shoestore.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private const val IS_LOGGED = true

class LoginViewModel : ViewModel() {


    private val _loginState = MutableLiveData<Boolean>()
    val loginState: LiveData<Boolean>
        get() = _loginState


    // A simple login check
    fun verifyLogin(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty())
            _loginState.value = IS_LOGGED
    }
}