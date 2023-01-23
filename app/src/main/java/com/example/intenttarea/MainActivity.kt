package com.example.intenttarea

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var random = (0..9).random()
    var random2 = (0..9).random()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val foto: Button = findViewById(R.id.button)
        foto.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
            }
        }
        val calculo: Button = findViewById(R.id.button2)
        calculo.setOnClickListener {
            val intento1 = Intent(this, SecondActivity::class.java)
            // Añade datos adicionales al Intent
            intento1.putExtra("num1", random)
            intento1.putExtra("num2", random2)
            // Inicia la segunda actividad
            startActivityForResult(intento1, REQUEST_OPERATION)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageView = findViewById<ImageView>(R.id.imageView)
        // Definimos el text view para mostrar el dato que nos manda la Second
        val textView = findViewById<TextView>(R.id.texto)
        if (resultCode != Activity.RESULT_OK) return
        Log.d("asd", requestCode.toString())
        // Puedo distinguir diferentes acciones según el requestCode
        when (requestCode) {
            REQUEST_IMAGE_CAPTURE -> {
                //Recoge la foto y la muestra por pantalla
                val thumbnail = data?.extras!!.get("data") as Bitmap
                imageView.setImageBitmap(thumbnail)
                // Do other work with full size photo saved in locationForPhotos
            }
            REQUEST_OPERATION -> {
                // si el intent no es null muestro el resultado
                if (data != null) {
                    Log.d("asd", "recibido")
                    var resultado = data.getIntExtra("suma", 0).toString()
                    if (resultado.toInt() == (random + random2)) {
                        textView.text = "Bien " + data.getIntExtra("suma", 0).toString()
                    } else {
                        textView.text = "Mal " + data.getIntExtra("suma", 0).toString()
                    }

                }; }
        }
    }

    companion object {
        const val REQUEST_IMAGE_CAPTURE = 1
        const val REQUEST_OPERATION = 2
    }
}
