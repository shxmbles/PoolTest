package com.example.pool.dto

import com.google.gson.annotations.SerializedName

/**
 * A JSONProduct
 *
 * @property title, refers to the name of a product
 * @property link, a string that leads to the product on amazon.com
 * @property JSONMainImage, an internal JSON item that contains further data
 * @constructor creates a JSONProduct object based on properties for use in creating a Product object with the API
 */
public class JSONProduct(@SerializedName("title") var title: String, @SerializedName("link") var link: String, @SerializedName("main_image") var JSONMainImage: JSONMainImage) {
    /**
     * @return JSONMainImage object
     */
    @JvmName("getJSONMain_Image1")
    fun getJSONMain_Image(): JSONMainImage {
        return JSONMainImage
    }
    /**
     * @return link
     */
    @JvmName("getLink1")
    fun getLink(): String {
        return link
    }
    /**
     * @return title
     */
    @JvmName("getTitle1")
    fun getTitle(): String {
        return title
    }
    /**
     * @param JSONMainImage to set this.JSONMainImage
     */
    @JvmName("setJSONMain_Image1")
    fun setJSONMain_Image(JSONMainImage: JSONMainImage) {
        this.JSONMainImage = JSONMainImage
    }
    /**
     * @param link to set this.link
     */
    @JvmName("setLink1")
    fun setLink(link: String) {
        this.link = link
    }
    /**
     * @param title to set this.title
     */
    @JvmName("setTitle1")
    fun setTitle(title: String) {
        this.title = title
    }

}