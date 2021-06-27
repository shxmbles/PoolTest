package com.example.pool.ui.main

import androidx.fragment.app.Fragment
import com.example.pool.dto.Algae
import com.example.pool.dto.Chemical

class MainFragment : Fragment() {
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
    val gAlgae = Algae(type= "Green", hoursCantSwim= 0F, ozPerGallon= 0F, chlBoostPerGallon= 0F)
    val yAlgae = Algae(type= "Yellow", hoursCantSwim= 0F, ozPerGallon= 0F, chlBoostPerGallon= 0F)
    val bAlgae = Algae(type= "Black", hoursCantSwim= 0F, ozPerGallon= 0F, chlBoostPerGallon= 0F)
}