package com.example.pool.dto

class Product(val title: String, val link: String, val main_image: String) {
    override fun toString(): String {
        return "$title is available for purchase on Amazon at $link"
    }
}