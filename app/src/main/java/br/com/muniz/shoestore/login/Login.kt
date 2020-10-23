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

    override fun onResume() {
        // if the user is already logged skip the login screen
        if (viewModel.loginState.value!!)
            goToWelcomeFragment()

        super.onResume()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater, R.layout.fragment_login, container, false
        )

        // get the view model from ViewModelProvider
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.buttonLogin.setOnClickListener {
            verifyLogin(binding)
        }

        binding.buttonCreateAccount.setOnClickListener {
            verifyLogin(binding)
        }

        viewModel.loginState.observe(viewLifecycleOwner, Observer { newLoginState ->
            // if log in successfully goes to Welcome Fragment
            if (newLoginState)
                goToWelcomeFragment()
        })

        return binding.root
    }


    // In this case the login and create account button go to the same fragment
    private fun verifyLogin(binding: FragmentLoginBinding?) {
        viewModel.verifyLogin(
            binding?.editEmail?.text.toString(),
            binding?.editPassword?.text.toString()
        )
    }

    // Calls the Welcome Fragment
    private fun goToWelcomeFragment() {
        findNavController().navigate(R.id.action_login_to_welcome)
    }

}