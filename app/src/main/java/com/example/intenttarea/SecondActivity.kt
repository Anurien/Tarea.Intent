package com.example.intenttarea

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class SecondActivity : AppCompatActivity() {
    //Lista de elementos para el spinner
    var numeros = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        // Recoge el Intent que ha iniciado la actividad
        val intent = intent
        // Get the Intent that started this activity and extract the string
        val mnum1 = intent.getIntExtra("num1", 7)
        val mnum2 = intent.getIntExtra("num2", 7)
        val textView = findViewById<TextView>(R.id.textView)
        val textView1 = findViewById<TextView>(R.id.selecionado)

        textView.text = mnum1.toString()
        textView1.text = mnum2.toString()
        val botonsalir = findViewById<Button>(R.id.salir)
        //es un combobox con varias opciones
        var spinner = findViewById<Spinner>(R.id.spinner_sample)
        // Crea un ArrayAdapter usando un simple spinner layout ay el array de numeros
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, numeros)
        // Set layout to use when the list of choices appear
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Asociar el adaptador al spinner
        spinner!!.setAdapter(aa)

        botonsalir.setOnClickListener {
            val numPosition = spinner.selectedItemPosition
            val valornum = numeros.get(numPosition);
            //val hora_añadir_tarea = spinner.selectedItem.toString()
            val num1 = intent.getIntExtra("num1", 5)
            val num2 = intent.getIntExtra("num2", 5)
            intent.putExtra("suma", valornum)
            Log.d("mensaje", "actualizado")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

}