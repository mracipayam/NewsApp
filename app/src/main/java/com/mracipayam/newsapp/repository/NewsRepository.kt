package com.mracipayam.newsapp.repository

import com.mracipayam.newsapp.api.RetrofitInstance
import com.mracipayam.newsapp.db.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)
}