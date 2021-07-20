package com.example.pool.ui.main

import androidx.lifecycle.MutableLiveData
import com.example.pool.dto.Product
import com.example.pool.service.ProductService

class MainViewModel {
    var product: MutableLiveData<Product> = MutableLiveData<Product>()
    var productService: ProductService = ProductService()
    /**
     * assigns var products with JSON data from fetchProducts()
     */
    fun fetchProduct(myASIN: String) {
        product = productService.fetchProduct(myASIN)
    }
}