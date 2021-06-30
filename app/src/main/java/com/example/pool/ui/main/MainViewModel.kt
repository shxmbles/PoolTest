package com.example.pool.ui.main

import androidx.lifecycle.MutableLiveData
import com.example.pool.dto.Product
import com.example.pool.service.ProductService

class MainViewModel {
    var product: MutableLiveData<Product> = MutableLiveData<Product>()
    var productService: ProductService = ProductService()
    /**
     * assigns var countries with JSON data from fetchCountries()
     */
    fun fetchProduct(myASIN: String) {
        product = productService.fetchProduct(myASIN)
    }
}