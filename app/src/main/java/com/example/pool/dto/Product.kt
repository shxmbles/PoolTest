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
    override fun toString(): String {
        return "$title is available for purchase on Amazon at: $link";
    }

    /**
     * @return title value of product
     */
    @JvmName("getTitle1")
    fun getTitle(): String {
        return this.title;
    }
    /**
     * @return link value of product
     */
    @JvmName("getLink1")
    fun getLink(): String {
        return this.link;
    }
    /**
     * @return image value of product
     */
    @JvmName("getMain_image1")
    public fun getImage(): String {
        return this.main_image
    }


}