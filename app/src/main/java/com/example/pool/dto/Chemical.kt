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
 * @property ASINTiers, Codes corresponding to different quality tiers of products.
 * @constructor creates a chemical based on supplied properties
 */
class Chemical(val name: String, val okRange: Array<Float>, val hoursCantSwim: Float, val ozPerGallon: Float, val ASINTiers: Array<String>) {
    /**
     * @override toString function
     * @return chemical name and a small summary about the chemical
     */
    @Override
    override fun toString(): String {
        val okRangeStart = this.okRange[0].toString()
        val okRangeEnd = this.okRange[okRange.size - 1].toString()

        var numHours: String = "immediately"
        if (this.hoursCantSwim === 1F) {
            numHours = "1 hour"
        } else if (this.hoursCantSwim > 1F) {
            numHours = "$this.hoursCantSwim hours"
        }

        return this.name + "is a chemical with an acceptable range of " + okRangeStart +
                " to " + okRangeEnd + ", and is safe for pool goers " + numHours + " after use."
    }
}
