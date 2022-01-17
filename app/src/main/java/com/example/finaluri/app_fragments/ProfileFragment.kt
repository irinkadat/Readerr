package com.example.finaluri.app_fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.finaluri.MainActivity
import com.example.finaluri.R
import com.example.finaluri.UserInfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class ProfileFragment:Fragment(R.layout.fragment_profile) {

    private lateinit var imageViewAvatar: ImageView
    private lateinit var name : TextView
    private lateinit var userEmail : TextView
    private lateinit var buttonEditProfile : Button
    private lateinit var buttonLogout: Button
    private  val auth = FirebaseAuth.getInstance()
    private  val db: DatabaseReference = FirebaseDatabase.getInstance().getReference("UserInfo")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageViewAvatar = view.findViewById(R.id.imageViewAvatar)
        name = view.findViewById(R.id.userName)

        userEmail = view.findViewById(R.id.userEmail)
        userEmail.text = FirebaseAuth.getInstance().currentUser?.email


        buttonEditProfile = view.findViewById(R.id.buttonEditProfile)
        buttonLogout = view.findViewById(R.id.buttonLogout)

        buttonEditProfile.setOnClickListener{

            findNavController().navigate(R.id.action_profileFragment_to_editProfileFragment)
        }

        db.child(auth.currentUser?.uid!!).addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val userInfo:UserInfo = snapshot.getValue(UserInfo::class.java)?: return

                Glide.with(this@ProfileFragment)
                    .load(userInfo.imageUrl)
                    .centerCrop()
                    .into(imageViewAvatar)

                name.text = userInfo.userName
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })


        buttonLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)


        }




        }
}