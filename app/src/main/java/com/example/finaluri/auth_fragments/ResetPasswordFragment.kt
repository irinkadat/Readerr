package com.example.finaluri.auth_fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.finaluri.R
import com.google.firebase.auth.FirebaseAuth

class ResetPasswordFragment:Fragment(R.layout.fragment_reset_password) {
    private lateinit var buttonSend: Button
    private lateinit var editTextEmail: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        buttonSend = view.findViewById(R.id.buttonSendEmail)
        editTextEmail = view.findViewById(R.id.editTextEmail)


        buttonSend.setOnClickListener {
            val email = editTextEmail.text.toString()
            android.util.Patterns.EMAIL_ADDRESS.matcher(email)

            if (email.isEmpty()) {
                Toast.makeText(context, "Enter email!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(context, "Invalid email", Toast.LENGTH_SHORT).show()

            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(context, "Check your e-mail!", Toast.LENGTH_SHORT).show()
                        val action = ResetPasswordFragmentDirections.actionResetPasswordFragmentToLoginFragment()
                        navController.navigate(action)
                    }else{
                        Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show()
                    }
                }

    }

    }
}