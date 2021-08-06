package com.example.pool.dao

import retrofit2.Call
import android.util.Log
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.pool.dto.Product

/**
 * Interface that contains the query for the product API
 */
interface ProductDAO {
    @GET("/request")
    fun getProduct(
        @Query(value = "asin") myASIN: String = "B073JYC4XM",
        @Query(value = "api_key") api_key: String ="73DA2F0D640F48CC9CF908DFC31A208C",
        @Query(value = "type") type: String = "product",
        @Query(value = "amazon_domain") myDomain: String = "amazon.com")
         : Call<Product>
}