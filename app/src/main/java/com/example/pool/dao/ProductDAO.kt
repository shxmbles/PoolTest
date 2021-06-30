package com.example.pool.dao

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.pool.dto.Product

interface ProductDAO {
    @GET("/request?api_key=D07FB49BFD304162AD9692342ADB6AB7&type=product&amazon_domain=amazon.com")
    fun getProduct(@Query("asin")myASIN:String) : Call<Product>
}