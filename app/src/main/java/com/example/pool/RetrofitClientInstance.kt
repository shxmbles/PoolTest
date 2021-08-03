package com.example.pool

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit used to implement API call
 */
object RetrofitClientInstance {
    private var retrofit: Retrofit? = null;
    private val BASE_URL = "https://api.rainforestapi.com";

    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}