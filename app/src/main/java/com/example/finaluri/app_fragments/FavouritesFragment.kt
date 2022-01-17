package com.example.finaluri.app_fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finaluri.Book
import com.example.finaluri.R
import com.example.finaluri.RecyclerViewAdapter2
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.util.ArrayList

class FavouritesFragment:Fragment(R.layout.fragment_favourites) {



    private lateinit var recyclerView2: RecyclerView
    private lateinit var bookArrayList: ArrayList<Book>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerView2 = view.findViewById(R.id.recyclerView2)
        bookArrayList = arrayListOf<Book>()
        recyclerView2.setHasFixedSize(true)
        getBookData()





    }

    private fun getBookData() {

        val auth = FirebaseAuth.getInstance()
        val db = FirebaseDatabase.getInstance().getReference("Favourites").child(auth.currentUser?.uid!!)
        db.addValueEventListener(object :ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){

                    for (bookSnapshot in snapshot.children){

                        val book = bookSnapshot.getValue(Book::class.java)
                        bookArrayList.add(book!!)

                    }

                    recyclerView2.adapter = RecyclerViewAdapter2(bookArrayList)
                    recyclerView2.layoutManager = LinearLayoutManager(context)

                }

            }

            override fun onCancelled(error: DatabaseError) {

            }


        })
    }


}