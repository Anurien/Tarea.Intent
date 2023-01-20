package com.example.intenttarea

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        // Recoge el Intent que ha iniciado la actividad
        val intent = intent
        // Get the Intent that started this activity and extract the string
        val message = intent.getIntExtra("EXTRA_MESSAGE", 7)
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = message.toString()
        val botonsalir = findViewById<Button>(R.id.salir)

        botonsalir.setOnClickListener {
            val num1 = intent.getIntExtra("num1", 5)
            val num2 = intent.getIntExtra("num2", 5)
            intent.putExtra("suma", num1 + num2)
            Log.d("mensaje", "actualizado")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}