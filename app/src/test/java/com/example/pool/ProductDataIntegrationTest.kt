package com.example.pool

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.pool.dto.JSONMainImage
import com.example.pool.dto.JSONProduct
import com.example.pool.dto.Product
import com.example.pool.service.ProductService
import com.example.pool.ui.main.MainViewModel
import io.mockk.mockk
import org.junit.Test

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

    var productService = mockk<ProductService>()

    @Test
    fun confirmChlorine_outputsChlorine () {
        var product = Product(JSONProduct(title="Chlorine", link="https://link", JSONMainImage = JSONMainImage(imageLink="image_url")))
        assertEquals("Chlorine is available for purchase on Amazon at https://link", product.toString());
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
        mvm.fetchProduct(myASIN="B00PZZFG0O");
    }

    private fun thenResultContainsChlorine() {
        var chlorineCalled = false;
        mvm.product.observeForever {
            assertNotNull(it)
            if (it.getJSONProduct().getTitle() == "CLOROX Pool&Spa XtraBlue 3-Inch Long Lasting Chlorinating Tablets, 5-Pound Chlorine"
                && it.getJSONProduct().getLink() == "https://www.amazon.com/CLOROX-Pool-Spa-XtraBlue-Chlorinating/dp/B00PZZFG0O"
                && it.getJSONProduct().getJSONMain_Image().getImageLink() == "https://images-na.ssl-images-amazon.com/images/I/616baa8-DxL.jpg"
            ) {
                chlorineCalled = true
            }
        }
        assertTrue(chlorineCalled)
    }

}

