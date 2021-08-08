package com.example.pool

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.pool.dto.JSONProduct
import com.example.pool.dto.Product
import com.example.pool.ui.main.MainViewModel
import org.junit.Test
import android.util.Log
import com.example.pool.dto.BuyBox
import com.example.pool.dto.Price
import org.junit.Assert.*
import org.junit.Rule
import org.junit.rules.TestRule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ProductDataIntegrationTest {

    @get:Rule
    var rule: TestRule =  InstantTaskExecutorRule()
    lateinit var mvm: MainViewModel

    @Test
    fun confirmChlorine_outputsChlorine () {
        val product = Product(JSONProduct(title="Chlorine", link="https://link"), buyBox= BuyBox(Price("$0.00")
        ) )
        assertEquals("Chlorine is available for purchase on Amazon at: https://link", product.toString())
    }

    @Test
    fun callForChlorine_returnsChlorine() {
        givenAFeedOfProductDataAreAvailable()
        whenCallForChlorine()
        thenResultContainsChlorine()
    }


    private fun givenAFeedOfProductDataAreAvailable() {
        mvm = MainViewModel()
    }


    private fun whenCallForChlorine() {
        mvm.fetchProduct(myASIN="B00PZZFG0O")
    }

    private fun thenResultContainsChlorine() {
        var chlorineCalled = false
        mvm.product.observeForever {
            assertNotNull(it)
            if (it.getTitle() == "CLOROX Pool&Spa XtraBlue 3-Inch Long Lasting Chlorinating Tablets, 5-Pound Chlorine"
                && it.getLink() == "https://www.amazon.com/CLOROX-Pool-Spa-XtraBlue-Chlorinating/dp/B00PZZFG0O") {
                chlorineCalled = true
            }
            assertTrue(chlorineCalled)
        }
    }

}

