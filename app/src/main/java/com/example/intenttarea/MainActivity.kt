package com.example.intenttarea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val foto: Button = findViewById(R.id.button)
        foto.setOnClickListener {

        }
        val calculo: Button = findViewById(R.id.button2)
        calculo.setOnClickListener {

        }
        
    }
}