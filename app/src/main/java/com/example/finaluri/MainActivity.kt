package com.example.finaluri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.finaluri.auth_fragments.LoginFragment
import com.example.finaluri.auth_fragments.RegisterFragment
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val controller = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.mainFragment,
                R.id.loginFragment,
                R.id.registerFragment,
                R.id.resetPasswordFragment
            )
        )

        setupActionBarWithNavController(controller,appBarConfiguration)


        if(FirebaseAuth.getInstance().currentUser !=null) {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

    }


}