package com.example.pool.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pool.R
import com.example.pool.dto.Product
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.Observer
import com.example.pool.dto.ProductAndImage

class ProductActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.products)


        recycler_view.adapter = ProductItemAdapter(myArray)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)

    }

    private var myArray = arrayOfNulls<ProductAndImage>(7)
    var mvm: MainViewModel = MainViewModel()
    var images = ArrayList<Int>()

    //this will return an array of product objects to be used in recycler view
    public fun getAllProducts(): Int {
        var poolResults = MainActivity().getResults()
        var chem: String
        poolResults.forEach {
            if (it.amountNeeded != 0F) {
                images.add(it.image)
            }
        }
        var asins = MainActivity().generateASINList(poolResults = poolResults.toTypedArray())
        var index = 0
        asins.forEach { asin ->
            mvm.fetchProduct(myASIN = asin)
            mvm.product.observe(this, Observer {
                myArray[index]!!.setProduct(it)
            })
            myArray[index]!!.setImage(images[index])
            index++
        }
        return index
    }
}