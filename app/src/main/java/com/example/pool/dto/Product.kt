package com.example.pool.dto

class Product(val title: String, val link: String, val main_image: String) {
    override fun toString(): String {
        return this.title + " is available for purchase on Amazon at " + this.link;
    }
}