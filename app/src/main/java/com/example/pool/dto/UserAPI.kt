package com.example.pool.dto

import retrofit2.http.GET
import retrofit2.http.Query

interface UserAPI {
    @GET("/request")
    suspend fun getPost(@Query(value = "asin") myASIN: String = "B073JYC4XM",
                        @Query(value = "api_key") api_key: String ="73DA2F0D640F48CC9CF908DFC31A208C",
                        @Query(value = "type") type: String = "product",
                        @Query(value = "amazon_domain") myDomain: String = "amazon.com"): JSONProduct


}
