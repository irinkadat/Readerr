package com.example.finaluri.auth_fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.finaluri.R

class MainFragment: Fragment(R.layout.fragment_main),View.OnClickListener {

    private lateinit var loginButton: Button
    private lateinit var registerButton: Button
    var navController: NavController?= null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        loginButton = view.findViewById(R.id.loginButton)
        registerButton = view.findViewById(R.id.registerButton)
        loginButton.setOnClickListener(this)
        registerButton.setOnClickListener(this)



    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.loginButton -> navController!!.navigate(R.id.action_mainFragment_to_loginFragment)
            R.id.registerButton -> navController!!.navigate(R.id.action_mainFragment_to_registerFragment)
        }

    }
}