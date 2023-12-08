package com.laxmi.newsreaderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class NewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val urlToImage = intent.getStringExtra("URL_TO_IMAGE")
        val title = intent.getStringExtra("TITLE")
        val publishedAt = intent.getStringExtra("PUBLISHED_AT")
        val description = intent.getStringExtra("DESCRIPTION")

        val newsImageView = findViewById<ImageView>(R.id.newss_image)
        val newsTitle = findViewById<TextView>(R.id.newss_title)
        val newsPublish = findViewById<TextView>(R.id.newss_published_at)
        val newsDesc = findViewById<TextView>(R.id.newss_description)

        Glide.with(this).load(urlToImage).into(newsImageView)
        newsTitle.text = title
        newsPublish.text = publishedAt
        newsDesc.text = description
    }
}