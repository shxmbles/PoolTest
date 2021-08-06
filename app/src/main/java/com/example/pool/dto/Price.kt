package com.example.pool.dto

import com.google.gson.annotations.SerializedName

/**
 * A Price
 *
 * @property raw, a String that represents the price of an amazon product
 * @constructor creates a price object that contains a string value of the price
 */
public class Price(@SerializedName("raw") private var raw: String) {
    /**
     * @return raw
     */
    public fun getRaw(): String {
        return raw
    }
    /**
     * @param raw sets this.raw
     */
    public fun setRaw(raw: String) {
        this.raw = raw
    }
}
