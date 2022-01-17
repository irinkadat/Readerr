package com.example.finaluri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class RecyclerViewAdapter2(private val list: ArrayList<Book>):
    RecyclerView.Adapter<RecyclerViewAdapter2.BookViewHolder>() {

    class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val imageView1: ImageView = itemView.findViewById(R.id.imageViewNew)
        private val textView2: TextView = itemView.findViewById(R.id.textViewNew)
        private val textView3: TextView = itemView.findViewById(R.id.textViewNew2)
        private val favBtn2 : ImageView = itemView.findViewById(R.id.favBtn2)


        fun setData(book: Book) {

            Glide.with(itemView.context)
                .load(book.imgUrl)
                .centerCrop()
                .into(imageView1)

            textView2.text = book.title
            textView3.text = book.text



            favBtn2.setOnClickListener {
                val id = book.id


                val auth = FirebaseAuth.getInstance()
                val db = FirebaseDatabase.getInstance().getReference("Favourites")
                db.child(auth.currentUser?.uid!!).child(id.toString())
                    .removeValue()

            }




        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_2, parent, false)
        return BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = list[position]
        holder.setData(book)



    }

    override fun getItemCount()= list.size

}

