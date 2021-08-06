package com.example.pool.dao

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.pool.dto.Product

/**
 * Interface that contains the query for the product API
 */
interface ProductDAO {
    @GET("/request")
    fun getProduct(
        @Query(value = "asin") myASIN: String,
        @Query(value = "api_key") api_key: String ="D07FB49BFD304162AD9692342ADB6AB7",
        @Query(value = "type") type: String = "product",
        @Query(value = "amazon_domain") myDomain: String = "amazon.com")
         : Call<Product>
}