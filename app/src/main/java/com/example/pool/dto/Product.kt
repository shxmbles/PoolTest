package com.example.pool.dto

import com.google.gson.annotations.SerializedName

/**
 * A Product
 *
 * @property JSONProduct, an internal JSON item that contains further data
 * @constructor creates a product based on supplied properties
 */
public class Product(@SerializedName("product") private var JSONProduct: JSONProduct, @SerializedName("buybox_winner") private var buyBox: BuyBox) {

    /**
     * @return buyBox object
     */
    public fun getBuyBox(): BuyBox {
        return buyBox
    }
    /**
     * @param buyBox sets this.buyBox
     */
    public fun setBuyBox(buyBox: BuyBox) {
        this.buyBox = buyBox
    }
    /**
     * @return raw from JSONProduct object
     */
    public fun getRaw() {
        buyBox.getRaw()
    }

    /**
     * @return JSONProduct object
     */
    fun getJSONProduct(): JSONProduct {
        return JSONProduct
    }
    /**
     * @param JSONProduct to set this.JSONProduct
     */
    fun setJSONProduct(JSONProduct: JSONProduct) {
        this.JSONProduct = JSONProduct
    }
    /**
     * @return title
     */
    fun getTitle(): String {
        return JSONProduct.getTitle()
    }
    /**
     * @return link
     */
    fun getLink(): String {
        return JSONProduct.getLink()
    }
    /**
     * @override toString function
     * @return product name and a link to the amazon site that sells it
     */
    @Override
    override fun toString(): String {
        return getTitle() + " is available for purchase on Amazon at: " + getLink() + ". It costs " + getRaw() + ".";
    }

}