package com.example.pool.ui.main

import android.text.Editable
import org.w3c.dom.Text
import retrofit2.http.Url

data class PoolStatusItem(val imageResource: Int, var Title: String, var Range: String, var poolStatus: String) {
    @JvmName("getTitle1")
    fun getTitle(): String
    {
        return Title
    }
    @JvmName("getPoolStatus1")
    fun getPoolStatus(): String
    {
        return poolStatus
    }
    @JvmName("setPoolTitle1")
    fun setTitle(newTitle: String)
    {
        poolStatus = newTitle
    }
    @JvmName("setPoolStatus1")
    fun setPoolStatus(newStatus: String)
    {
        poolStatus = newStatus
    }
}