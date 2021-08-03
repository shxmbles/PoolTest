package com.example.pool.dto
/**
 * A Product
 *
 * @property title, the name of a product
 * @property link, a string that contains a link to the product on the amazon site
 * @property main_image, url of an image of the product
 * @constructor creates a chemical based on supplied properties
 */
class Product(val title: String, val link: String, val main_image: String) {
    /**
     * @override toString function
     * @return product name and a link to the amazon site that sells it
     */
    @Override
    override public fun toString(): String {
        return this.title + " is available for purchase on Amazon at: " + this.link;
    }

}