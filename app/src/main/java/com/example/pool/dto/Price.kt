package com.example.pool.dto

import com.google.gson.annotations.SerializedName

public class Price(@SerializedName("raw") private var raw: String) {

    public fun getRaw(): String {
        return raw
    }
    public fun setRaw(raw: String) {
        this.raw = raw
    }
}
