package com.android.ex2_movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private val movieTrailerUrl = "https://www.youtube.com/watch?v=6ZfuNTqbHE8"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.layout_2bii_button)
        button.setOnClickListener{
            openWebPage(movieTrailerUrl)
        }

    }

    fun openWebPage(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}
