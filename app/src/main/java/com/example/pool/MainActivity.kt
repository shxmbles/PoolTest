package com.example.pool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pool.dto.Chemical
import com.example.pool.dto.Algae

class MainActivity : AppCompatActivity() {


    //each chemical can be created here using the chemical class
    val exampleChemical = Chemical(name= "example", okRange = arrayOf(1F, 5F), hoursCantSwim = 0F,
        ozPerGallon = .005F)
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
    val greenAlgae = Algae(type= "Green", hoursCantSwim= 0F, ozPerGallon= 0F, chlBoostPerGallon= 0F)
    val yellowAlgae = Algae(type= "Yellow", hoursCantSwim= 0F, ozPerGallon= 0F, chlBoostPerGallon= 0F)
    val blueAlgae = Algae(type= "Black", hoursCantSwim= 0F, ozPerGallon= 0F, chlBoostPerGallon= 0F)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}