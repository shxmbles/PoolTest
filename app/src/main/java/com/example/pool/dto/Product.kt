package com.example.pool.dto

import com.google.gson.annotations.SerializedName

/**
 * A Product
 *
 * @property JSONProduct, an internal JSON item that contains further data
 * @constructor creates a producct based on supplied properties
 */
public class Product(@SerializedName("product") private var JSONProduct: JSONProduct) {

    /**
     * @return JSONProduct object
     */
    fun getJSONProduct(): JSONProduct {
        return JSONProduct
    }
    /**
     * @param JSONProduct to set this.JSONProduct
     */
    fun setJSONProduct(JSONProduct: JSONProduct) {
        this.JSONProduct = JSONProduct
    }
    /**
     * @return title
     */
    fun getTitle(): String {
        return this.JSONProduct.getTitle()
    }
    /**
     * @return link
     */
    fun getLink(): String {
        return this.JSONProduct.getLink()
    }
    /**
     * @override toString function
     * @return product name and a link to the amazon site that sells it
     */
    @Override
    override fun toString(): String {
        return JSONProduct.getTitle() + " is available for purchase on Amazon at: " + JSONProduct.getLink();
    }

}