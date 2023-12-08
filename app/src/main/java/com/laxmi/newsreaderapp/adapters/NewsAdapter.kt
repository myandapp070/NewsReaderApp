package com.laxmi.newsreaderapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.laxmi.newsreaderapp.NewActivity
import com.laxmi.newsreaderapp.R
import com.laxmi.newsreaderapp.models.Article

class NewsAdapter(val context: Context, val articles: List<Article>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.news_row_items, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        Glide.with(context).load(articles[position].urlToImage).into(holder.urlToImage)
        holder.title.text = articles[position].title
        holder.publishedAt.text = articles[position].publishedAt
        holder.description.text = articles[position].description
        holder.itemView.setOnClickListener {
            val intent = Intent(context, NewActivity::class.java)
            intent.putExtra("URL_TO_IMAGE", articles[position].urlToImage)
            intent.putExtra("TITLE", articles[position].title)
            intent.putExtra("PUBLISHED_AT", articles[position].publishedAt)
            intent.putExtra("DESCRIPTION", articles[position].description)
            context.startActivity(intent)
        }
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val urlToImage = itemView.findViewById<ImageView>(R.id.news_image)
        val title = itemView.findViewById<TextView>(R.id.news_title)
        val publishedAt = itemView.findViewById<TextView>(R.id.news_published_at)
        val description = itemView.findViewById<TextView>(R.id.news_description)
    }

}