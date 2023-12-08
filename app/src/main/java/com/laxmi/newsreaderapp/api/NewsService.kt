package com.laxmi.newsreaderapp.api

import com.laxmi.newsreaderapp.models.NewsList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "d5a7b56c9b8246a3859a857d7d254a3d"

interface NewsService {

    @GET("/v2/top-headlines?apiKey=$API_KEY")
    fun getNews(@Query("country") country: String): Call<NewsList>
}