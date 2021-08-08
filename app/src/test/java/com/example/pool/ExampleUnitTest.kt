package com.example.pool

import android.util.Log
import com.example.pool.dto.Algae
import com.example.pool.dto.Chemical
import org.junit.Test
import com.example.pool.ui.main.MainActivity

import org.junit.Assert.*

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
        val chemical = Chemical(name="example", toAddName="example", okRange=arrayOf(0F, 1F), deviation= 0F, currentLevel= 0F, hoursCantSwim=1F, ozPer10KGallon=.5F, ASINTiers = arrayOf("ASIN1", "ASIN2", "ASIN3"))
        assertTrue(
            chemical.reportString(true) == "example is a chemical with an acceptable range of 0.0 to 1.0. Your level is in a stable range."
        )
    }
    @Test
    fun algaeDTO_toStringFormat() {
        val algae = Algae(type="example", hoursCantSwim=0F, ozPerGallon=.5F, chlBoostPerGallon=1F, ASINTag = "ASIN" )
        assertTrue(algae.toString() == "example should never appear, and any amount is dangerous. Your pool is safe for pool goers.")
    }
    @Test
    fun chemicalDTO_returnAmountAdd() {
        val chemical = Chemical(name="example", toAddName="example", okRange=arrayOf(0F, 1F), deviation= 0F, currentLevel= 0F, hoursCantSwim=1F, ozPer10KGallon=.5F, ASINTiers = arrayOf("ASIN1", "ASIN2", "ASIN3"))
        val amountNeeded = chemical.calculateAmountNeeded(50F)
        assertTrue(amountNeeded == 0F)
    }
    @Test
    fun chemicalDTO_returnAmountRemove() {
        val chemical = Chemical(name="example", toAddName="example", okRange=arrayOf(0F, 1F), deviation= 0F, currentLevel= 0F, hoursCantSwim=1F, ozPer10KGallon=.5F, ASINTiers = arrayOf("ASIN1", "ASIN2", "ASIN3"))
        val amountRemove = chemical.calculateAmountToRemove(50F)
        assertTrue(amountRemove == 0F)
    }
    @Test
    fun algaeDTO_returnAlgaecideAdd() {
        val algae = Algae(type="example", hoursCantSwim=0F, ozPerGallon=.5F, chlBoostPerGallon=1F, ASINTag = "ASIN" )
        val amountAdd = algae.calcAlgNeeded(50F)
        assertTrue(amountAdd == 25F)
    }
    @Test
    fun algaeDTO_returnChlorineAdd() {
        val algae = Algae(type="example", hoursCantSwim=0F, ozPerGallon=.5F, chlBoostPerGallon=1F, ASINTag = "ASIN" )
        val amountAdd = algae.calcChlNeeded(50F)
        assertTrue(amountAdd == 100F)
    }
}