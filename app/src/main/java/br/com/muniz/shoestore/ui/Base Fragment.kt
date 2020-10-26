package br.com.muniz.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController

open class BaseFragment : Fragment() {

    private lateinit var context: MainActivity

    protected lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        context = activity as MainActivity
        navController = context.getNavController()
    }
}
