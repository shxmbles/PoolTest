package com.example.pool.dto

import com.google.gson.annotations.SerializedName

/**
 * A JSONMainImage
 *
 * @property imageLink, a String that refers to an image of a product
 * @constructor creates a JSONMainImage object based on properties for use in creating a Product object with the API
 */
public class JSONMainImage(@SerializedName("link") var imageLink: String) {
    /**
     * @return JSONProduct object
     */
    @JvmName("getLink1")
    fun getImageLink(): String {
        return imageLink
    }
    /**
     * @param imageLink string used to set this.imageLink
     */
    @JvmName("setImageLink1")
    fun setImageLink(imageLink: String) {
        this.imageLink = imageLink
    }
}