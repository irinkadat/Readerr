package com.example.finaluri.auth_fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.finaluri.R
import com.google.firebase.auth.FirebaseAuth

class RegisterFragment: Fragment(R.layout.fragment_register) {

    private lateinit var buttonSubmit: Button
    private lateinit var editTextUserName:EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextRepeatPassword: EditText


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        editTextUserName = view.findViewById(R.id.editTextPersonName)
        editTextEmail = view.findViewById(R.id.editTextEmail)
        editTextPassword = view.findViewById(R.id.editTextPassword)
        editTextRepeatPassword = view.findViewById(R.id.editTextRepeatPassword)
        buttonSubmit=view.findViewById(R.id.buttonSubmit)


        buttonSubmit.setOnClickListener {
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()
            val repeatPassword=editTextRepeatPassword.text.toString().trim()
            val userName = editTextUserName.text.toString()


            if (email.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()||userName.isEmpty()) {
                Toast.makeText(context, "Empty!", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
            }
            else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(context, "Invalid email", Toast.LENGTH_SHORT).show()

            }

            else if (password!=repeatPassword) {
                Toast.makeText(context, "Repeated password isn't correct!", Toast.LENGTH_SHORT).show()

            }
            else if (repeatPassword.length<9 || password.length< 9) {
                Toast.makeText(context, "Password must contain at least 9 symbol!", Toast.LENGTH_SHORT).show()

            }
            else if (!password.contains(Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!_?&])"))) {
                Toast.makeText(context, "Password must contain both symbols and numbers!", Toast.LENGTH_SHORT).show()


            }

            else {
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
                            navController.navigate(action)

                        }else{
                            Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show()
                        }
                    }
            }



        }


    }




}




