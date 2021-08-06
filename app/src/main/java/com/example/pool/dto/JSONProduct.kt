package com.example.pool.dto

import com.google.gson.annotations.SerializedName

public class JSONProduct(@SerializedName("title") var title: String, @SerializedName("link") var link: String, @SerializedName("main_image") var JSONMainImage: JSONMainImage) {

    @JvmName("getJSONMain_Image1")
    fun getJSONMain_Image(): JSONMainImage {
        return JSONMainImage
    }
    @JvmName("getLink1")
    fun getLink(): String {
        return link
    }
    @JvmName("getTitle1")
    fun getTitle(): String {
        return title
    }
    @JvmName("setJSONMain_Image1")
    fun setJSONMain_Image(JSONMainImage: JSONMainImage) {
        this.JSONMainImage = JSONMainImage
    }
    @JvmName("setLink1")
    fun setLink(link: String) {
        this.link = link
    }
    @JvmName("setTitle1")
    fun setTitle(title: String) {
        this.title = title
    }

}