package com.example.pool.dto

import com.example.pool.MainActivity
import com.example.pool.dto.Chemical


/**
 * Algae Type
 *
 * @property type, whether the Algae is green, black, or gold in color
 * @property hoursCantSwim, number of hours it is unsafe to swim
 * @property ozPerGallon, ounces of algecide needed per gallon of pool water. Again, can adjust units
 * of measure
 * @property chlBoostPerGallon, amount of chlorine needed to boost the algecide for algae elimination
 * @property ASINTag, Codes corresponding to different quality tiers of products.
 * @constructor creates an algae object based on supplied properties
 */
class Algae(val type: String, val hoursCantSwim: Float, val ozPerGallon: Float, val chlBoostPerGallon: Float, val ASINTag: String) {

    /**
     * @override toString function
     * @return chemical name and a small summary about the chemical
     */
    @Override
    override fun toString(): String {
        return "$type algae"
    }
}
