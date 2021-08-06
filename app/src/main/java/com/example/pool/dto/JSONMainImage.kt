package com.example.pool.dto

import com.google.gson.annotations.SerializedName

public class JSONMainImage(@SerializedName("link") var imageLink: String) {
    @JvmName("getLink1")
    fun getImageLink(): String {
        return this.imageLink
    }
}