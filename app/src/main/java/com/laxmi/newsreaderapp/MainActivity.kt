package com.laxmi.newsreaderapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.laxmi.newsreaderapp.adapters.NewsAdapter
import com.laxmi.newsreaderapp.api.NewsService
import com.laxmi.newsreaderapp.api.RetrofitHelper
import com.laxmi.newsreaderapp.repository.NewsRepository
import com.laxmi.newsreaderapp.viewmodels.MainViewModel
import com.laxmi.newsreaderapp.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var newsRecyclerView: RecyclerView
    lateinit var adapter: NewsAdapter
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsRecyclerView = findViewById(R.id.news_recycler_view)

        val repository = (application as NewsApplication).newsRepository
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository))[MainViewModel::class.java]

        mainViewModel.news.observe(this) {
            //Log.d("Result==", it.articles[0].author)
            adapter = NewsAdapter(this, it.articles)
            newsRecyclerView.layoutManager=LinearLayoutManager(this)
            newsRecyclerView.adapter = adapter

        }
    }
}