package com.example.finaluri.app_fragments

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.finaluri.R

class BrowserFragment: Fragment(R.layout.fragment_browser) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bookUrl = BrowserFragmentArgs.fromBundle(requireArguments()).bookUrl
        val book = Uri.parse(bookUrl)
        val link = Intent(Intent.ACTION_VIEW, book)
        link.setPackage("com.browser.android")
        try {
            startActivity(link)
        }
        catch (e: ActivityNotFoundException) {
           startActivity(Intent(Intent.ACTION_VIEW, book))
        }
}
}