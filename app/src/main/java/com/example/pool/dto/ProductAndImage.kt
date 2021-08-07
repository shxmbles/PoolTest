package com.example.pool.dto

class ProductAndImage(var product: Product, var image: Int) {

    fun getTitle(): String {
        return product.getTitle()
    }

    fun getRaw(): String {
        return product.getRaw()
    }

    fun getLink(): String {
        return product.getLink()
    }
    @JvmName("getImage1")
    fun getImage(): Int {
        return image
    }

    @JvmName("setProduct1")
    fun setProduct(product: Product) {
        this.product = product
    }

    @JvmName("setImage1")
    fun setImage(image: Int) {
        this.image = image
    }


}