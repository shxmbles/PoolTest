package com.example.pool.dto

import com.google.gson.annotations.SerializedName

/**
 * A BuyBox
 *
 * @property price, an internal JSON item that contains further data
 * @constructor creates a BuyBox based on supplied properties
 */
public class BuyBox(@SerializedName("price") private var price: Price) {
    /**
     * @return price object
     */
    public fun getPrice(): Price {
        return price
    }
    /**
     * @param price sets this.price
     */
    public fun setPrice(price: Price) {
        this.price = price
    }
    /**
     * @return raw from a BuyBox object
     */
    public fun getRaw(): String {
        return price.getRaw()
    }
}
