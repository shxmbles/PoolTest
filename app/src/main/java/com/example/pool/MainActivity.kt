package com.example.pool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pool.dto.Chemical
import com.example.pool.dto.Algae
import com.example.pool.ui.main.MainViewModel
//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    //each chemical can be created here using the chemical class
    val chlorine = Chemical(name= "chl", okRange = arrayOf(1F, 5F), hoursCantSwim = 8F,
            ozPerGallon = .005F)
    val alkalinity = Chemical(name= "alk", okRange = arrayOf(80F, 120F), hoursCantSwim = 0F,
            ozPerGallon = .005F)
    val calciumHardness = Chemical(name= "cal", okRange = arrayOf(200F, 300F), hoursCantSwim = 0F,
            ozPerGallon = .005F)
    val pH = Chemical(name= "pH", okRange = arrayOf(7.4F, 7.6F), hoursCantSwim = 0F,
            ozPerGallon = .005F)
    val cyanuricAcid = Chemical(name= "cya", okRange = arrayOf(30F, 100F), hoursCantSwim = 0F,
            ozPerGallon = .005F)
    val totalDissolvedSolids = Chemical(name= "tds", okRange = arrayOf(0F, 1500F), hoursCantSwim = 0F,
            ozPerGallon = .005F)
    val phosphates = Chemical(name= "pho", okRange = arrayOf(0F, 100F), hoursCantSwim = 0F,
            ozPerGallon = .005F)
    val gAlgae = Algae(type= "Green", hoursCantSwim= 0F, ozPerGallon= 0F, chlBoostPerGallon= 0F)
    val yAlgae = Algae(type= "Yellow", hoursCantSwim= 0F, ozPerGallon= 0F, chlBoostPerGallon= 0F)
    val bAlgae = Algae(type= "Black", hoursCantSwim= 0F, ozPerGallon= 0F, chlBoostPerGallon= 0F)

    val myProduct = MainViewModel().fetchProduct(myASIN="B00PZZFG0O")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val exampleList  = generatePoolStatusList(2)
//        recycler_view.adapter = PoolItemAdapter(exampleList)
//        recycler_view.layoutManager = LinearLayoutManager(this)
//        recycler_view.setHasFixedSize(true)
    }

    private fun generatePoolStatusList(size: Int) : List<poolStatusItem> {
        val list = ArrayList<poolStatusItem>()

        val item = poolStatusItem(imageResource = 1, "Test", "Low", "0")
        list += item

        return list
    }

    /**
     * @param priceLevel is a value 0 (low), 1 (medium), or 2 (high) which corresponds to an index in the chemical arrays
     * @param productType is the chemical name ("chlorine", "cyanuricAcid", "phIncrease", "phDecrease", "algaecide", "calcium", "sodiumBicarbonate")
     * @return the asin of the product which we will fetch from the amazon api
     */
    private fun getASIN(priceLevel: Int, productType: String) : String {
        //5 lbs
        var chlorineList = arrayOf("B096N1N5DJ", "B00PZZFG0O", "B08QMW3XJV")
        //5 lbs
        var cyanuricAcidList = arrayOf("B00TNWGZE6", "B011AFBUTI", "B07FPZP6ZX")
        //4 lbs
        var phIncreaseList  = arrayOf("B084GPWRBL", "B08PG4C2NQ", "B004WDVT6K")
        //5 lbs for most
        var phDecreaseList = arrayOf("B084GPS6KR", "B077715Y9L", "B07YZPNWDL")
        //sizing wasn't listed for all
        var algaecideList = arrayOf("43128CLX", "B0049VQ89S", "B002WKJAYS")
        //4 lbs
        var calciumList = arrayOf("B000UVQUJ4", "B084GQH8YF", "B07QXTNV1B")
        //5 lbs
        var sodiumBicarbonateList = arrayOf("B076KSBF69", "B0774M73SF", "B073H1NJKK")

        if (productType.equals("chlorine"))
            return chlorineList[priceLevel]
        else if (productType.equals("cyanuricAcid"))
            return cyanuricAcidList[priceLevel]
        else if (productType.equals("phIncrease"))
            return phIncreaseList[priceLevel]
        else if (productType.equals("phDecrease"))
            return phDecreaseList[priceLevel]
        else if (productType.equals("algaecide"))
            return algaecideList[priceLevel]
        else if (productType.equals("calcium"))
            return calciumList[priceLevel]
        else if (productType.equals("sodiumBicarbonate"))
            return sodiumBicarbonateList[priceLevel]
        else
            return ""
    }

}