package com.example.finaluri.auth_fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finaluri.R
import com.example.finaluri.UserInfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class EditProfileFragment: Fragment(R.layout.fragment_edit_profile) {

    private lateinit var userName: EditText
    private lateinit var url : EditText
    private lateinit var editTextPassword : EditText
    private lateinit var changePassword : Button
    private lateinit var buttonSave : Button

    private  val auth = FirebaseAuth.getInstance()
    private  val db = FirebaseDatabase.getInstance().getReference("UserInfo")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userName = view.findViewById(R.id.editTextPersonName)
        editTextPassword = view.findViewById(R.id.editTextPassword)
        changePassword = view.findViewById(R.id.buttonChangePassword)
        buttonSave = view.findViewById(R.id.buttonSave)
        url = view.findViewById(R.id.editUrl)



        changePassword.setOnClickListener{

            val newPassword = editTextPassword.text.toString().trim()

            if(newPassword.isEmpty() || newPassword.length <9 ) {
                Toast.makeText(context, "Invalid password!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else if (!newPassword.contains(Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!_?&])"))) {
                Toast.makeText(context, "Password must contain both symbols and numbers!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }
            FirebaseAuth.getInstance().currentUser?.updatePassword(newPassword)
                ?.addOnCompleteListener { task ->
                    if(task.isSuccessful) {
                        Toast.makeText(context, "Success!", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_editProfileFragment_to_profileFragment)
                    }else{
                        Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        buttonSave.setOnClickListener{
            val userName = userName.text.toString()
            val url = url.text.toString()
            val userInfo = UserInfo(userName,url)

            db.child(auth.currentUser?.uid!!).setValue(userInfo)

            findNavController().navigate(R.id.action_editProfileFragment_to_profileFragment)


        }


    }
}