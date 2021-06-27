package com.example.pool.dto

/**
 * A Chemical
 *
 * @property name, the name of a chemical
 * @property okRange, an array of two floats with index 0 being the lowest acceptable value and index
 * 1 being the highest
 * @property hoursCantSwim, number of hours it is unsafe to swim per oz (could be other unit of measure)
 * of chemical added
 * @property ozPerGallon, ounces of chemical needed per gallon of pool water. Again, can adjust units
 * of measure
 * @constructor creates a chemical based on supplied properties
 */
class Chemical(val name: String, val okRange: Array<Float>, val hoursCantSwim: Float, val ozPerGallon: Float) {
    /**
     * @param poolSize is the current level of a certain chemical
     * @return amount of chemical that needs to be added, or zero for none. a negative number
     * represents having too much of a chemical, and needing to avoid adding it
     */
    var amountNeeded: Float = 0F;
    fun calculateAmountNeeded(poolSize: Float): Float {
        amountNeeded = ozPerGallon * poolSize
        return amountNeeded
    }

    /**
     * @param poolSize should be the value returned by calculateAmountNeeded, and the amount of a
     * certain chemical to be removed
     * @return the amount of chemicals to add in order to neutralize an excess level
     */
    fun calculateAmountToRemove(poolSize: Float): Float {
        return (-amountNeeded) * poolSize
    }

    /**
     * @override toString function
     * @return chemical name and a small summary about the chemical
     */
    @Override
    override fun toString(): String {
        //may need to be modified for units
        var hour = "hours"
        if (this.hoursCantSwim == 1F) {
            hour = "hour"
        }
        return if (this.hoursCantSwim > 0 ) {
             this.name + "is a chemical with an acceptable range of " + this.okRange[0].toString() + " to " +
                    this.okRange[1].toString() + ", and is unsafe for pool goers"+ hoursCantSwim + hour + " after use."
        }
        else
        {
            return this.name + "is a chemical with an acceptable range of " + this.okRange[0].toString() + " to " +
            this.okRange[1].toString() + ", and is safe for pool goers."
        }
    }
}