package com.example.pool.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pool.R
import com.example.pool.dto.Chemical
import com.example.pool.dto.Algae
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    //Chemicals used in pools declared
    val chlorine = Chemical(name= "Chlorine", okRange= arrayOf(1F, 5F), hoursCantSwim= 8F,
        ozPerGallon= .005F, ASINTiers= arrayOf("B096N1N5DJ", "B00PZZFG0O", "B08QMW3XJV"))

    val alkalinity = Chemical(name= "Alkalinity", okRange= arrayOf(80F, 120F), hoursCantSwim= 0F,
        ozPerGallon= .005F, ASINTiers= arrayOf("B076KSBF69", "B0774M73SF", "B073H1NJKK"))

    val calciumHardness = Chemical(name= "Calcium Hardness", okRange= arrayOf(200F, 300F), hoursCantSwim= 0F,
        ozPerGallon= .005F, ASINTiers= arrayOf("B000UVQUJ4", "B084GQH8YF", "B07QXTNV1B"))

    val pH = Chemical(name= "pH", okRange= arrayOf(7.4F, 7.6F), hoursCantSwim= 0F,
        ozPerGallon= .005F, ASINTiers= arrayOf("B084GPWRBL", "B08PG4C2NQ", "B004WDVT6K","B084GPS6KR", "B077715Y9L", "B07YZPNWDL"))

    val cyanuricAcid = Chemical(name= "Cyanuric Acid", okRange= arrayOf(30F, 100F), hoursCantSwim= 0F,
        ozPerGallon= .005F, ASINTiers= arrayOf("B00TNWGZE6", "B011AFBUTI", "B07FPZP6ZX"))

    val totalDissolvedSolids = Chemical(name= "Total Dissolved Solids", okRange= arrayOf(0F, 1500F), hoursCantSwim= 0F,
        ozPerGallon= .005F, ASINTiers= arrayOf("N/A"))

    val phosphates = Chemical(name= "Phosphates", okRange= arrayOf(0F, 100F), hoursCantSwim= 0F,
        ozPerGallon= .005F, ASINTiers= arrayOf("N/A"))

    val greenAlgae = Algae(type= "Green", hoursCantSwim= 0F, ozPerGallon= 0F, chlBoostPerGallon= 0F, ASINTag = "B002WKJAYS")
    val yellowAlgae = Algae(type= "Yellow", hoursCantSwim= 0F, ozPerGallon= 0F, chlBoostPerGallon= 0F, ASINTag = "B01LW1QNZ7")
    val blackAlgae = Algae(type= "Black", hoursCantSwim= 0F, ozPerGallon= 0F, chlBoostPerGallon= 0F, ASINTag = "B00BGNLPCW")






    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val exampleList = generatePoolStatusList(2)
        recycler_view.adapter = PoolItemAdapter(exampleList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)

//        val algaeDropDownItems = arrayOf("Green", "Yellow", "Black")
//        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,algaeDropDownItems)
//
//        algaeDropdown.adapter = arrayAdapter
//        algaeDropdown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//
//            }
//
//        }

    }

    private fun generatePoolStatusList(size: Int) : List<PoolStatusItem> {

        val myProduct = MainViewModel().fetchProduct(myASIN="B00PZZFG0O")
        Log.e("Beeleave", myProduct.toString())
        val icon = arrayOf<Int>(R.drawable.chlorine)
        val list = ArrayList<PoolStatusItem>()

        val chl = PoolStatusItem(imageResource = icon[0], "Chlorine", "Safe Range: 1-5", "")
        list += chl

        val cAcid = PoolStatusItem(imageResource = icon[0], "Cyanuric Acid", "Safe Range: 30-100", "")
        list += cAcid

        val pH = PoolStatusItem(imageResource = icon[0], "pH", "Safe Range: 7.4-7.6", "")
        list += pH

        val alkalinity = PoolStatusItem(imageResource = icon[0], "Alkalinity", "Safe Range: 80-120", "")
        list += alkalinity

        val phosphates = PoolStatusItem(imageResource = icon[0], "Phosphates", "Safe Range: 0-100", "")
        list += phosphates

        val cHardness = PoolStatusItem(imageResource = icon[0], "Calcium Hardness", "Safe Range: 200-300", "")
        list += cHardness

        val totalDissolvedSolids = PoolStatusItem(imageResource = icon[0], "Total Dissolved Solids", "Safe Range: 0-1500", "")
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