package com.example.pool.dto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserNetwork {
    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://amazon.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserAPI::class.java)
    }
}