package com.mracipayam.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.mracipayam.newsapp.databinding.ActivityNewsBinding
import com.mracipayam.newsapp.db.ArticleDatabase
import com.mracipayam.newsapp.repository.NewsRepository

class NewsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNewsBinding
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navController = binding.newsNavHostFragment.getFragment<NavHostFragment>().navController
        binding.bottomNavigationView.setupWithNavController(navController)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application,newsRepository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(NewsViewModel::class.java)


    }

    //https://newsapi.org/v2/everything?q=tesla&from=2023-03-06&sortBy=publishedAt&apiKey=25000c3d31184555900f727ea06959f7


}
