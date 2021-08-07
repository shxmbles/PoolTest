package com.example.pool.dto

/**
 * A Chemical
 *
 * @property name, the name of a chemical
 * @property toAddName, name to the product used to change the chemical's level.
 * @property okRange, an array of two floats with index 0 being the lowest acceptable value and index
 * 1 being the highest
 * @property deviation, the value ozPer10KGallon multiplied by poolSize will shift the chemical level
 * @property currentLevel, the chemical's level as specified by the user
 * @property hoursCantSwim, number of hours it is unsafe to swim per oz (could be other unit of measure)
 * of chemical added
 * @property ozPer10KGallon, ounces of chemical needed per gallon of pool water. Again, can adjust units
 * of measure
 * @property ASINTiers, Codes corresponding to different quality tiers of products.
 * @constructor creates a chemical based on supplied properties
 */
class Chemical(val name: String, val toAddName: String, val okRange: Array<Float>, val deviation: Float,
               var currentLevel: Float, val hoursCantSwim: Float, val ozPer10KGallon: Float, val ASINTiers: Array<String>) {
    /**
     * @param poolSize is the current level of a certain chemical
     * @return amount of chemical that needs to be added, or zero for none. a negative number
     * represents having too much of a chemical, and needing to avoid adding it
     */
    var amountNeeded: Float = 0F;
    fun calculateAmountNeeded(poolSize: Float): Float {
        var deviationHolder: Float = 0F
        if(currentLevel > okRange[1])
        {
            deviationHolder = (currentLevel - okRange[1]) / deviation
        }
        amountNeeded = ozPer10KGallon * (poolSize/10000) * deviationHolder
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
     * @param canSwim, a boolean that says if the pool will be safe to swim in
     * @return chemical name and a small summary about the chemical
     */
    fun reportString(canSwim: Boolean): String {
        //may need to be modified for units
        var chemAmount = "oz"
        var hour = "hours"
        if (this.amountNeeded >= 16)
        {
            chemAmount = "lbs"
        }

        if (this.hoursCantSwim == 1F) {
            hour = "hour"
        }

        if (canSwim == false) {
            return this.name + "is a chemical with an acceptable range of " + this.okRange[0].toString() + " to " +
                    this.okRange[1].toString() + ", and your levels are unsafe for pool goers. Add " +
                    amountNeeded + " " + chemAmount + " of " + toAddName +
                    " to your pool as instructed by the directions on the packaging and wait to swim for " +
                    hoursCantSwim + hour + " after use."
        }
        else
        {
            return this.name + "is a chemical with an acceptable range of " + this.okRange[0].toString() + " to " +
            this.okRange[1].toString() + ", and is safe for pool goers."
        }
    }
}