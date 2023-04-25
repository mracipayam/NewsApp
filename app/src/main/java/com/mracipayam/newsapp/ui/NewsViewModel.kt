package com.mracipayam.newsapp.ui

import androidx.lifecycle.ViewModel
import com.mracipayam.newsapp.repository.NewsRepository

class NewsViewModel(
    val newsRepository: NewsRepository
) : ViewModel() {

}