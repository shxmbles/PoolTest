package com.example.pool.dto

import com.google.gson.annotations.SerializedName

/**
 * A Product
 *
 * @property title, the name of a product
 * @property link, a string that contains a link to the product on the amazon site
 * @property JSONMainImage, url of an image of the product
 * @constructor creates a chemical based on supplied properties
 */
public class Product(@SerializedName("product") private var JSONProduct: JSONProduct) {

    fun getJSONProduct(): JSONProduct {
        return JSONProduct
    }
    fun setJSONProduct(JSONProduct: JSONProduct) {
        this.JSONProduct = JSONProduct
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