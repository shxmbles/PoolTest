package com.example.pool.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pool.R
import com.example.pool.dto.Chemical
import com.example.pool.dto.Algae
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    //Chemicals used in pools declared
    val chlorine = Chemical(name= "chl", okRange= arrayOf(1F, 5F), hoursCantSwim= 8F,
        ozPerGallon= .005F, ASINTiers= arrayOf("B096N1N5DJ", "B00PZZFG0O", "B08QMW3XJV"))

    val alkalinity = Chemical(name= "alk", okRange= arrayOf(80F, 120F), hoursCantSwim= 0F,
        ozPerGallon= .005F, ASINTiers= arrayOf("B076KSBF69", "B0774M73SF", "B073H1NJKK"))

    val calciumHardness = Chemical(name= "cal", okRange= arrayOf(200F, 300F), hoursCantSwim= 0F,
        ozPerGallon= .005F, ASINTiers= arrayOf("B000UVQUJ4", "B084GQH8YF", "B07QXTNV1B"))

    val pH = Chemical(name= "pH", okRange= arrayOf(7.4F, 7.6F), hoursCantSwim= 0F,
        ozPerGallon= .005F, ASINTiers= arrayOf("B084GPWRBL", "B08PG4C2NQ", "B004WDVT6K","B084GPS6KR", "B077715Y9L", "B07YZPNWDL"))

    val cyanuricAcid = Chemical(name= "cya", okRange= arrayOf(30F, 100F), hoursCantSwim= 0F,
        ozPerGallon= .005F, ASINTiers= arrayOf("B00TNWGZE6", "B011AFBUTI", "B07FPZP6ZX"))

    val totalDissolvedSolids = Chemical(name= "tds", okRange= arrayOf(0F, 1500F), hoursCantSwim= 0F,
        ozPerGallon= .005F, ASINTiers= arrayOf("N/A"))

    val phosphates = Chemical(name= "pho", okRange= arrayOf(0F, 100F), hoursCantSwim= 0F,
        ozPerGallon= .005F, ASINTiers= arrayOf("N/A"))

    val greenAlgae = Algae(type= "Green", hoursCantSwim= 0F, ozPerGallon= 0F, chlBoostPerGallon= 0F, ASINTag = "B002WKJAYS")
    val yellowAlgae = Algae(type= "Yellow", hoursCantSwim= 0F, ozPerGallon= 0F, chlBoostPerGallon= 0F, ASINTag = "B01LW1QNZ7")
    val blackAlgae = Algae(type= "Black", hoursCantSwim= 0F, ozPerGallon= 0F, chlBoostPerGallon= 0F, ASINTag = "B00BGNLPCW")
    val myProduct = MainViewModel().fetchProduct(myASIN="B00PZZFG0O")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val exampleList = generatePoolStatusList(2)
        recycler_view.adapter = PoolItemAdapter(exampleList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }

    private fun generatePoolStatusList(size: Int) : List<PoolStatusItem> {

        val icon = arrayOf<Int>(R.drawable.chlorine)
        val list = ArrayList<PoolStatusItem>()

        val chl = PoolStatusItem(imageResource = icon[0], "Chlorine", "Low", "1")
        list += chl

        val cAcid = PoolStatusItem(imageResource = icon[0], "Cyanuric Acid", "Low", "2")
        list += cAcid

        val pH = PoolStatusItem(imageResource = icon[0], "pH", "Low", "2")
        list += pH

        val dissolvedSolids = PoolStatusItem(imageResource = icon[0], "Dissolved Solids", "Low", "2")
        list += dissolvedSolids

        val alkalinity = PoolStatusItem(imageResource = icon[0], "Alkalinity", "Low", "2")
        list += alkalinity

        val phosphates = PoolStatusItem(imageResource = icon[0], "Phosphates", "Low", "2")
        list += phosphates

        val cHardness = PoolStatusItem(imageResource = icon[0], "Calcium Hardness", "Low", "2")
        list += cHardness

        val totalDissolvedSolids = PoolStatusItem(imageResource = icon[0], "Total Dissolved Solids", "Low", "2")
        list += totalDissolvedSolids



        return list
    }

    /**
     * @param priceLevel is a value 0 (low), 1 (medium), or 2 (high) which corresponds to an index in the chemical arrays. In the
     * case of algaecides, priceLevel will refer to the specific type of algae detected. The index for algae reads as thus: 0 (green), 1 (yellow)
     * or 2 (black.)
     * @param productType is the chemical name ("chlorine", "cyanuricAcid", "phIncrease", "phDecrease", "algaecide", "calcium", "sodiumBicarbonate")
     * @return the asin of the product which we will fetch from the amazon api
     */
    public fun getASIN(priceLevel: Int, productType: String) : String {
        when (productType) {
            "chlorine" -> return chlorine.ASINTiers[priceLevel]
            //5 lbs
            "cyanuricAcid" -> return cyanuricAcid.ASINTiers[priceLevel]
            //4 lbs
            "phIncrease" -> return pH.ASINTiers[priceLevel]
            //5 lbs for most
            "phDecrease" -> return pH.ASINTiers[priceLevel+3]
            //1 qt
            "greenAlgaecide" -> return greenAlgae.ASINTag
            //1 qt
            "yellowAlgaecide" -> return yellowAlgae.ASINTag
            //1 qt
            "blackAlgaecide" -> return blackAlgae.ASINTag
            //4 lbs
            "calcium" -> return calciumHardness.ASINTiers[priceLevel]
            //5 lbs
            "sodiumBicarbonate" -> return alkalinity.ASINTiers[priceLevel]
            else -> return ""
        }
    }

}