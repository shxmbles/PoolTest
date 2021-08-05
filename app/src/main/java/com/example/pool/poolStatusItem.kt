package com.example.pool

import android.text.Editable
import org.w3c.dom.Text
import retrofit2.http.Url

data class poolStatusItem(val imageResource: Int, val Title: String, val description: String, var poolStatus: String) {
}