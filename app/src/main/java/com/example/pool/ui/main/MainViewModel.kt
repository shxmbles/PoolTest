package com.example.pool.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pool.dto.JSONProduct
import com.example.pool.dto.Product
import com.example.pool.dto.TestJSON
import com.example.pool.dto.UserNetwork
import com.example.pool.service.ProductService
import kotlinx.coroutines.launch


class MainViewModel: ViewModel() {
    var product: MutableLiveData<Product> = MutableLiveData<Product>()
    var productService: ProductService = ProductService()
    /**
     * assigns var product with JSON data from fetchProducts()
     */
    fun fetchProduct(myASIN: String) {
        product = productService.fetchProduct(myASIN)
    }

    val myResponse: MutableLiveData<JSONProduct> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            myResponse.value = UserNetwork.retrofit.getPost()
        }
    }
}