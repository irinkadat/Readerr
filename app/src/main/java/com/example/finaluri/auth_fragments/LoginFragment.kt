package com.example.finaluri.auth_fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.finaluri.MainActivity2
import com.example.finaluri.R
import com.google.firebase.auth.FirebaseAuth


class LoginFragment:Fragment(R.layout.fragment_login) {


    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var buttonResetPassword: Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        buttonLogin = view.findViewById(R.id.buttonLogin)
        buttonResetPassword = view.findViewById(R.id.buttonResetPassword)
        editTextEmail = view.findViewById(R.id.editTextEmail)
        editTextPassword = view.findViewById(R.id.editTextPassword)


        buttonResetPassword.setOnClickListener {
            val action1 = LoginFragmentDirections.actionLoginFragmentToResetPasswordFragment()
            navController.navigate(action1)


        }
        buttonLogin.setOnClickListener {

            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(context,"Email is empty",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        gotoProfile()
                    }else{
                        Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show()
                    }

                }

        }
    }

    private fun gotoProfile() {
        val intent = Intent(activity, MainActivity2::class.java)
        startActivity(intent)



    }



}



