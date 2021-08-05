package com.example.pool.dto

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
     * @param poolGallonSize is the size of the pool
     * @return amount of algecide that needs to be added.
     */
    fun calcAlgNeeded(poolGallonSize: Float): Float {
        return ozPerGallon * poolGallonSize
    }
    /**
     * @param poolGallonSize is the size of the pool
     * @return amount of chlorine that needs to be added, or zero for none. a negative number
     * represents having too much, and needing to remove it.
     */
    fun calcChlNeeded(poolGallonSize: Float): Float {
        return (chlBoostPerGallon * 2) * poolGallonSize
    }

    /**
     * @override toString function
     * @return chemical name and a small summary about the chemical
     */
    @Override
    override fun toString(): String {
        if (this.hoursCantSwim > 0 ) {
            return this.type + " should never appear, and any amount is dangerous. " + this.ozPerGallon + " of algaecide and " +
            this.chlBoostPerGallon + " of chlorine is necessary, and isn't safe for pool goers until " + hoursCantSwim + " after use."
        }
        else
        {
            return this.type + " should never appear, and any amount is dangerous. Your pool is safe for pool goers."
        }
    }
}
