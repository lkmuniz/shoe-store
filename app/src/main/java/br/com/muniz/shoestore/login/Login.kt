package br.com.muniz.shoestore.login

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
import br.com.muniz.shoestore.databinding.FragmentLoginBinding

class Login : Fragment() {

    private lateinit var viewModel: LoginViewModel

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )

        // get the view model from ViewModelProvider
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.loginViewModel = viewModel

        viewModel.loginState.observe(viewLifecycleOwner, Observer { newLoginState ->
            // if log in successfully goes to Welcome Fragment
            if (newLoginState)
                goToWelcomeFragment()
        })

        return binding.root
    }

    // Calls the Welcome Fragment
    private fun goToWelcomeFragment() {
        findNavController().navigate(R.id.action_login_to_welcome)
    }

}