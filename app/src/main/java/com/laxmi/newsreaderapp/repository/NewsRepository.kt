package com.laxmi.newsreaderapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.laxmi.newsreaderapp.api.NewsService
import com.laxmi.newsreaderapp.models.NewsList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository(private val newsService: NewsService) {

    val Tag = "NewsRepository"

    private val newsLiveData = MutableLiveData<NewsList>()

    val news: LiveData<NewsList>
        get() = newsLiveData

    suspend fun getNews() {
        /*val result = newsService.getNews()
        if (result?.body() != null) {
            newsLiveData.postValue(result.body())
        }*/

        val news = newsService.getNews("in")
        news.enqueue(object : Callback<NewsList> {
            override fun onResponse(call: Call<NewsList>, response: Response<NewsList>) {
                if (response?.body() != null) {
                    newsLiveData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<NewsList>, t: Throwable) {
                Log.d(Tag, "Error in Fetching News", t)
            }
        })
    }
}