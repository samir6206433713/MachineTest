package com.tutorial.machinetest.display

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.tutorial.machinetest.R

class DisplayActivity : AppCompatActivity() {
    var imageView2: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        Toast.makeText(this, "Please Wait PICASSO IS LOADING", Toast.LENGTH_LONG).show()
        imageView2 = findViewById(R.id.imageView2)
        val sessionId = intent.getStringExtra("image")
        Picasso.get().load(sessionId).into(imageView2)
    }
}