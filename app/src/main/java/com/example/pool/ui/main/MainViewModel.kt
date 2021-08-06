package com.example.pool.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pool.dto.Product
import com.example.pool.service.ProductService


class MainViewModel: ViewModel() {
    var product: MutableLiveData<Product> = MutableLiveData<Product>()
    var productService: ProductService = ProductService()
    /**
     * assigns var product with JSON data from fetchProducts()
     */
    fun fetchProduct(myASIN: String) {
        product = productService.fetchProduct(myASIN)
    }

}