package com.example.pool.dao

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.pool.dto.Product
import retrofit2.http.Path

interface ProductDAO {
    val parameter: String
    @GET("/request?api_key=D07FB49BFD304162AD9692342ADB6AB7")
    fun getProduct(
        @Query(value = "asin") myASIN: String,
        @Query(value = "type") type: String = "product",
        @Query(value = "amazon_domain") myDomain: String = "amazon.com")
         : Call<Product>
}