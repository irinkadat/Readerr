package com.example.finaluri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finaluri.app_fragments.HomeFragmentDirections
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class RecyclerViewAdapter(private val list: List<Book>):
    RecyclerView.Adapter<RecyclerViewAdapter.BookViewHolder>(){


    class BookViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {


        private val imageView: ImageView = itemView.findViewById(R.id.imageView2)
        private val textView: TextView = itemView.findViewById(R.id.textView4)
        private val textView2: TextView = itemView.findViewById(R.id.textView5)

        private val favButton: ImageView = itemView.findViewById(R.id.favBtn)
        private val readBookBtn:Button = itemView.findViewById(R.id.readBookBtn)
        fun setData(book: Book) {

            Glide.with(itemView.context)
                .load(book.imgUrl)
                .centerCrop()
                .into(imageView)

            textView.text = book.title
            textView2.text = book.text


            favButton.setOnClickListener{
                val title = book.title
                val url = book.imgUrl
                val text = book.text
                val id = book.id


                val bookInfo = Book(id,url,title,text)
                val auth = FirebaseAuth.getInstance()
                val db = FirebaseDatabase.getInstance().getReference("Favourites")
                db.child(auth.currentUser?.uid!!).child(id.toString()).setValue(bookInfo)


            }
            readBookBtn.setOnClickListener {
                val navController = Navigation.findNavController(itemView)
                val bookUrl = book.bookUrl
                val action = HomeFragmentDirections.actionHomeFragmentToBrowserFragment(bookUrl)
                navController.navigate(action)


//
//                val bookUrl = book.bookUrl
//                val book = Uri.parse(bookUrl)
//                val link = Intent(Intent.ACTION_VIEW, book)
//                link.setPackage("com.browser.android")
//                mContext.startActivity(link)
//                try {
//
//                }
//                catch (e: ActivityNotFoundException) {
//
////                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(bookUrl)))
//                }


            }



        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(itemView)

    }


    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = list[position]
        holder.setData(book)


        }

    override fun getItemCount() = list.size
    }






