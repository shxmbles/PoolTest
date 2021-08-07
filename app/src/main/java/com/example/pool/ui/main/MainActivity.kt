package com.example.pool.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pool.R
import com.example.pool.dto.Chemical
import com.example.pool.dto.Algae
import android.widget.Spinner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pool.dto.PoolResults
import com.example.pool.dto.Product
import com.example.pool.service.ProductService

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {
    lateinit var submit_info: Button

    var mvm: MainViewModel = MainViewModel()
    //Chemicals used in pools declared
    val chemData = ArrayList<Chemical>()
    var poolStatusList: List<PoolStatusItem> = listOf()
    var results: List<PoolResults> = listOf()


    val chlorine = Chemical(name= "Chlorine", toAddName="Pool Shock", okRange= arrayOf(1F, 5F), currentLevel=0F, deviation=0F,
        hoursCantSwim= 8F, ozPer10KGallon= .0001F, ASINTiers= arrayOf("B096N1N5DJ", "B00PZZFG0O", "B08QMW3XJV"))

    val alkalinity = Chemical(name= "Alkalinity", toAddName="Pool Shock", okRange= arrayOf(80F, 120F), currentLevel=0F, deviation=0F,
        hoursCantSwim= 0F, ozPer10KGallon=  400F, ASINTiers= arrayOf("B076KSBF69", "B0774M73SF", "B073H1NJKK"))

    val calciumHardness = Chemical(name= "Calcium Hardness", toAddName="Pool Shock", okRange= arrayOf(200F, 300F),  currentLevel=0F, deviation=0F,
        hoursCantSwim= 0F, ozPer10KGallon= .005F, ASINTiers= arrayOf("B000UVQUJ4", "B084GQH8YF", "B07QXTNV1B"))

    val pHData = Chemical(name= "pH", toAddName="Pool Shock", okRange= arrayOf(7.4F, 7.6F), currentLevel=0F, deviation=0F, hoursCantSwim= 0F,
        ozPer10KGallon= .0001F, ASINTiers= arrayOf("B084GPWRBL", "B08PG4C2NQ", "B004WDVT6K","B084GPS6KR", "B077715Y9L", "B07YZPNWDL"))

    val cyanuricAcid = Chemical(name= "Cyanuric Acid", toAddName="Pool Shock", okRange= arrayOf(30F, 100F), currentLevel=0F, deviation=0F,
        hoursCantSwim= 0F, ozPer10KGallon= .005F, ASINTiers= arrayOf("B00TNWGZE6", "B011AFBUTI", "B07FPZP6ZX"))

    val tds = Chemical(name= "Total Dissolved Solids", toAddName="Pool Shock", okRange= arrayOf(0F, 1500F), currentLevel=0F, deviation=0F,
        hoursCantSwim= 0F, ozPer10KGallon= .005F, ASINTiers= arrayOf("N/A"))

    val phos = Chemical(name= "Phosphates", toAddName="Pool Shock", okRange= arrayOf(0F, 100F), currentLevel=0F, deviation=0F,
        hoursCantSwim= 0F, ozPer10KGallon= .005F, ASINTiers= arrayOf("N/A"))

    val greenAlgae = Algae(type= "Green", hoursCantSwim= 0F, ozPerGallon= 0F, chlBoostPerGallon= 0F, ASINTag = "B002WKJAYS")
    val yellowAlgae = Algae(type= "Yellow", hoursCantSwim= 0F, ozPerGallon= 0F, chlBoostPerGallon= 0F, ASINTag = "B01LW1QNZ7")
    val blackAlgae = Algae(type= "Black", hoursCantSwim= 0F, ozPerGallon= 0F, chlBoostPerGallon= 0F, ASINTag = "B00BGNLPCW")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        submit_info=findViewById(R.id.submit_info)

        val spinner: Spinner = findViewById(R.id.algaeDropdown)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(this, R.array.algae_array, R.layout.selected_item)
            .also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(R.layout.item)
                // Apply the adapter to the spinner
                spinner.adapter = adapter
            }

        val exampleList = generatePoolStatusList(2)
        recycler_view.adapter = PoolItemAdapter(exampleList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)

        submit_info.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                clickSubmit(exampleList)
            }
        })
    }

    fun clickSubmit(chemList: List<PoolStatusItem>): List<PoolResults>
    {
        var results = ArrayList<PoolResults>()
        var index = 0

        chemList.forEach()
        {
            try {
                if (PoolItemAdapter.PoolItemViewHolder(recycler_view).status.text.toString()
                        .toFloat() >= chemData[index].okRange[0] &&
                    PoolItemAdapter.PoolItemViewHolder(recycler_view).status.text.toString()
                        .toFloat() <= chemData[index].okRange[1]
                ) {
                    val paragraph = chemData[index].reportString(true)
                    results += PoolResults(paragraph, chemData[index], 0F, index)
                }
                else {
                    Log.e("OutOfRange", PoolItemAdapter.PoolItemViewHolder(recycler_view).status.text.toString())
                    Log.e("OutOfRange", chemData[index].okRange[0].toString() + ", " + chemData[index].okRange[1].toString())
                }
            }
            catch (e: NumberFormatException)
            {

                Log.e("Error", "No input given")
            }
            index += 1
        }
        this.results = results
        return results
    }

    @JvmName("getResults1")
    public fun getResults(): List<PoolResults> {
        return results
    }

    fun generateASINList(poolResults: Array<PoolResults>): List<String> {
        var asins: ArrayList<String> = arrayListOf()
        var asin: String = ""
        poolResults.forEach()
        {
            if (it.amountNeeded != 0F && it.chemical.name != "pH") {
                asin = getASIN(it.chemical.name)
            }
            else if (it.amountNeeded != 0F) {
                if (it.amountNeeded > 0F) {
                    asin = getASIN("phIncrease")
                }
                else {
                    asin = getASIN("phDecrease")
                }
            }
            asins.add(asin)
        }
        return asins
    }

    fun generatePoolStatusList(size: Int) : List<PoolStatusItem> {

        val icon = arrayOf(R.drawable.chlorine, R.drawable.alkalinity, R.drawable.calcium, R.drawable.ph, R.drawable.cacid, R.drawable.solid, R.drawable.phosphates)
        val list = ArrayList<PoolStatusItem>()

        val chl = PoolStatusItem(imageResource = icon[0], "Chlorine", "Safe Range: 1-5", "")
        list += chl
        chemData += chlorine
        val alk = PoolStatusItem(imageResource = icon[1], "Alkalinity", "Safe Range: 80-120", "")
        list += alk
        chemData += alkalinity
        val cHardness = PoolStatusItem(imageResource = icon[2], "Calcium Hardness", "Safe Range: 200-300", "")
        list += cHardness
        chemData += calciumHardness
        val pH = PoolStatusItem(imageResource = icon[3], "pH", "Safe Range: 7.4-7.6", "")
        list += pH
        chemData += pHData
        val cAcid = PoolStatusItem(imageResource = icon[4], "Cyanuric Acid", "Safe Range: 30-100", "")
        list += cAcid
        chemData += cyanuricAcid
        val totalDissolvedSolids = PoolStatusItem(imageResource = icon[5], "Total Dissolved Solids", "Safe Range: 0-1500", "")
        list += totalDissolvedSolids
        chemData += tds
        val phosphates = PoolStatusItem(imageResource = icon[6], "Phosphates", "Safe Range: 0-100", "")
        list += phosphates
        chemData += phos
        poolStatusList = list
        return list
    }

    /**
     * @param priceLevel is a value 0 (low), 1 (medium), or 2 (high) which corresponds to an index in the chemical arrays. In the
     * case of algaecides, priceLevel will refer to the specific type of algae detected. The index for algae reads as thus: 0 (green), 1 (yellow)
     * or 2 (black.)
     * @param productType is the chemical name ("chlorine", "cyanuricAcid", "phIncrease", "phDecrease", "algaecide", "calcium", "sodiumBicarbonate")
     * @return the asin of the product which we will fetch from the amazon api
     */
    public fun getASIN(productType: String) : String {
        val priceLevel = 1
        when (productType) {
            "chlorine" -> return chlorine.ASINTiers[priceLevel]
            //5 lbs
            "cyanuricAcid" -> return cyanuricAcid.ASINTiers[priceLevel]
            //4 lbs
            "phIncrease" -> return pHData.ASINTiers[priceLevel]
            //5 lbs for most
            "phDecrease" -> return pHData.ASINTiers[priceLevel+3]
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