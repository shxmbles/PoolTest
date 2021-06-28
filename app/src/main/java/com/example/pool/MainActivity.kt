package com.example.pool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pool.dto.Chemical
import com.example.pool.dto.Algae
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    //The way that you guys were associating the variables slightly inefficient.
    //I think this would be a better way to make a single variable that is searchable

    //each chemical can be created here using the chemical class
    var chemicals = mutableListOf(
        Chemical(name= "example", okRange = arrayOf(1F, 5F), hoursCantSwim = 0F, ozPerGallon = .005F),
        Chemical(name= "chl", okRange = arrayOf(1F, 5F), hoursCantSwim = 8F, ozPerGallon = .005F),
        Chemical(name= "alk", okRange = arrayOf(80F, 120F), hoursCantSwim = 0F, ozPerGallon = .005F),
        Chemical(name= "cal", okRange = arrayOf(200F, 300F), hoursCantSwim = 0F, ozPerGallon = .005F),
        Chemical(name= "pH", okRange = arrayOf(7.4F, 7.6F), hoursCantSwim = 0F, ozPerGallon = .005F),
        Chemical(name= "cya", okRange = arrayOf(30F, 100F), hoursCantSwim = 0F, ozPerGallon = .005F),
        Chemical(name= "tds", okRange = arrayOf(0F, 1500F), hoursCantSwim = 0F, ozPerGallon = .005F),
        Chemical(name= "pho", okRange = arrayOf(0F, 100F), hoursCantSwim = 0F, ozPerGallon = .005F),
    )
    var algae = mutableListOf(
        Algae(type= "Green", hoursCantSwim= 0F, ozPerGallon= 0F, chlBoostPerGallon= 0F),
        Algae(type= "Yellow", hoursCantSwim= 0F, ozPerGallon= 0F, chlBoostPerGallon= 0F),
        Algae(type= "Black", hoursCantSwim= 0F, ozPerGallon= 0F, chlBoostPerGallon= 0F)

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //NOW YOU CAN EASILY CALL ANY OF THE LISTED CHEMICALS WITH A SINGLE SEARCH
        //Here is a quick toString of the chemical with the name example
        var exampleChemical = chemicals.find { it.name.equals("example") }
        var exampleAlgae = algae.find { it.type.equals("Green") }
        println(exampleChemical.toString())
        println(exampleAlgae.toString())

        //I mentioned in chemicals.json that I think that this data is more suited to be in a Json file,
        //Ive been using Gson to quickly parse Json and it works well when working with alot of data
        println(Gson().toJson(chemicals))
    }
}