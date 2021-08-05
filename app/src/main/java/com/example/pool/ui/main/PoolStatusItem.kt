package com.example.pool.ui.main

import android.text.Editable
import org.w3c.dom.Text
import retrofit2.http.Url

data class PoolStatusItem(val imageResource: Int, val Title: String, val Range: String, var poolStatus: String) {
}