package com.mracipayam.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mracipayam.newsapp.R

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
    }

    //https://newsapi.org/v2/everything?q=tesla&from=2023-03-06&sortBy=publishedAt&apiKey=25000c3d31184555900f727ea06959f7

}