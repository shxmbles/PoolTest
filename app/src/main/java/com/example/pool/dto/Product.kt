package com.example.pool.dto

/**
 * A Product
 *
 * Listing products that will help each problem with the pool system,displayed with links to them and photos of the suggested products to be used
 */

class Product(val title: String, val link: String, val main_image: String) {
    override fun toString(): String {
        return this.title + " is available for purchase on Amazon at " + this.link;
    }
}