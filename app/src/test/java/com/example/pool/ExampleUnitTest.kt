package com.example.pool

import com.example.pool.dto.Algae
import com.example.pool.dto.Chemical
import org.junit.Test

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
        val chemical = Chemical(name="example", okRange=arrayOf(0F, 1F), hoursCantSwim=1F, ozPerGallon=.5F, ASINTiers = arrayOf("B00PZZFG0O"))
        assertTrue(chemical.toString().equals("example is a chemical with an acceptable range of 0 to 1" +
                "and is unsafe for pool goers 1 hour after use."))
    }
    @Test
    fun algaeDTO_toStringFormat() {
        val algae = Algae(type="example", hoursCantSwim=0F, ozPerGallon=.5F, chlBoostPerGallon=1F, ASINTag = "a1s2d")
        assertTrue(algae.toString().equals("example should never appear, and any amount is dangerous. Your pool is safe for pool goers."))
    }
}