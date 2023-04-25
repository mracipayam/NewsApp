package com.mracipayam.newsapp.api

import com.mracipayam.newsapp.util.Constants.Companion.BASE_URL
import okhttp3.logging.HttpLoggingInterceptor

class RetrofitInstance {
    companion object{
        private val retrofit by lazy {

            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = okhttp3.OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                .client(client)
                .build()
        }

        val api by lazy {
            retrofit.create(NewsAPI::class.java)
        }
    }
}