package com.example.pool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pool.dto.Chemical

class MainActivity : AppCompatActivity() {


    //each chemical can be created here using the chemical class
    val exampleChemical = Chemical(name= "example", okRange = arrayOf(1F, 5F), hoursCantSwim = 0F,
        ozPerGallon = .005F)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}