package com.example.pool.service

import androidx.lifecycle.MutableLiveData
import com.example.pool.RetrofitClientInstance
import com.example.pool.dao.ProductDAO
import com.example.pool.dto.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductService {
    /**
     * @return product from JSON data in MutableLiveData array list.
     */
    fun fetchProduct(myASIN: String): MutableLiveData<Product> {
        var _product = MutableLiveData<Product>()
        val service = RetrofitClientInstance.retrofitInstance?.create(ProductDAO::class.java)
        val call = service?.getProduct(myASIN)
        call?.enqueue(object: Callback<Product> {
            override fun onFailure(call: Call<Product>, t: Throwable) {
                val j = 1+1
                val i = 1+1
            }

            override fun onResponse(
                call: Call<Product>,
                response: Response<Product>
            ) {
                _product.value = response.body()
            }

        })
        return _product
    }
}