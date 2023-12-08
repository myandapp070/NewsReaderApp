package com.laxmi.newsreaderapp

import android.app.Application
import com.laxmi.newsreaderapp.api.NewsService
import com.laxmi.newsreaderapp.api.RetrofitHelper
import com.laxmi.newsreaderapp.repository.NewsRepository

class NewsApplication : Application() {

    lateinit var newsRepository: NewsRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val newsService = RetrofitHelper.getInstance().create(NewsService::class.java)
        newsRepository = NewsRepository(newsService)
    }
}