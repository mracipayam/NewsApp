package com.mracipayam.newsapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.mracipayam.newsapp.R
import com.mracipayam.newsapp.databinding.FragmentArticleBinding
import com.mracipayam.newsapp.ui.NewsActivity
import com.mracipayam.newsapp.ui.NewsViewModel

class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var viewModel: NewsViewModel
    val args : ArticleFragmentArgs by navArgs()

    private var _binding : FragmentArticleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArticleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as NewsActivity).viewModel
        val article = args.article
        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url?:"https://www.google.com/")
        }

        binding.fab.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view,"Article saved successfully",Snackbar.LENGTH_SHORT).show()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}