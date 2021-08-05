package com.example.pool

import com.example.pool.dto.Algae
import com.example.pool.dto.Chemical
import org.junit.Test
import com.example.pool.MainActivity

import org.junit.Assert.*
import java.util.Objects.toString

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun chemicalDTO_toStringFormat() {
        val chemical = Chemical(name="example", okRange=arrayOf(0F, 1F), hoursCantSwim=1F, ozPerGallon=.5F, ASINTiers = arrayOf("ASIN1", "ASIN2", "ASIN3"))
        assertTrue(
            chemical.toString() == "example is a chemical with an acceptable range of 0 to 1" +
                    "and is unsafe for pool goers 1 hour after use."
        )
    }
    @Test
    fun algaeDTO_toStringFormat() {
        val algae = Algae(type="example", hoursCantSwim=0F, ozPerGallon=.5F, chlBoostPerGallon=1F, ASINTag = "ASIN" )
        assertTrue(algae.toString() == "example should never appear, and any amount is dangerous. Your pool is safe for pool goers.")
    }
    @Test
    fun getASIN_returnsCorrectASIN() {
        val myASIN = MainActivity().getASIN(2, "chlorine")
        assertTrue(myASIN == "B08QMW3XJV")
    }
    @Test
    fun chemicalDTO_returnAmountAdd() {
        val chemical = Chemical(name="example", okRange=arrayOf(0F, 1F), hoursCantSwim=1F, ozPerGallon=.5F, ASINTiers = arrayOf("ASIN1", "ASIN2", "ASIN3"))
        val amountNeeded = chemical.calculateAmountNeeded(50F)
        assertTrue(amountNeeded == 25F)
    }
    @Test
    fun chemicalDTO_returnAmountRemove() {
        val chemical = Chemical(name="example", okRange=arrayOf(0F, 1F), hoursCantSwim=1F, ozPerGallon=.5F, ASINTiers = arrayOf("ASIN1", "ASIN2", "ASIN3"))
        val amountRemove = chemical.calculateAmountToRemove(50F)
        assertTrue(amountRemove == -25F)
    }
    @Test
    fun algaeDTO_returnAlgaecideAdd() {
        val algae = Algae(type="example", hoursCantSwim=0F, ozPerGallon=.5F, chlBoostPerGallon=1F, ASINTag = "ASIN" )
        val amountAdd = algae.calcAlgNeeded(50F)
        assertTrue(amountAdd == 50F)
    }
    @Test
    fun algaeDTO_returnClorineAdd() {
        val algae = Algae(type="example", hoursCantSwim=0F, ozPerGallon=.5F, chlBoostPerGallon=1F, ASINTag = "ASIN" )
        val amountAdd = algae.calcChlNeeded(50F)
        assertTrue(amountAdd == 100F)
    }
}