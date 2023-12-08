package com.laxmi.newsreaderapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laxmi.newsreaderapp.models.NewsList
import com.laxmi.newsreaderapp.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: NewsRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getNews()
        }
    }

    val news: LiveData<NewsList>
        get() = repository.news
}