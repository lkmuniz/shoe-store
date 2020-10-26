package br.com.muniz.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import br.com.muniz.shoestore.R
import br.com.muniz.shoestore.databinding.FragmentLoginBinding

class Login : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )

        binding.lifecycleOwner = this
        binding.login = this

        return binding.root
    }

    // Calls the Welcome Fragment
    fun goToWelcomeFragment() {
        findNavController().navigate(R.id.action_login_to_welcome)
    }

}