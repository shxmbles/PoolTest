package com.example.pool.service

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.pool.RetrofitClientInstance
import com.example.pool.dao.ProductDAO
import com.example.pool.dto.Product
import com.google.gson.Gson
import com.google.gson.TypeAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductService {
    /**
     * @return product from JSON data in MutableLiveData array list.
     */
    fun fetchProduct(myASIN: String): String {
        var _product = MutableLiveData<Product>()
        val service = RetrofitClientInstance.retrofitInstance?.create(ProductDAO::class.java)
        Log.e("service", service.toString())
        val call = service?.getProduct(myASIN)
        Log.e("call1", call.toString())
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
        return _product.value.toString()
    }
}