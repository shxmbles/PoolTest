package com.example.pool.dto

import com.google.gson.annotations.SerializedName

public class BuyBox(@SerializedName("price") private var price: Price) {

    public fun getPrice(): Price {
        return price
    }
    public fun setPrice(price: Price) {
        this.price = price
    }
    public fun getRaw(): String {
        return price.getRaw()
    }
}
