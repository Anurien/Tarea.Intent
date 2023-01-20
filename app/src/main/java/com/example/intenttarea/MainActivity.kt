package com.example.intenttarea

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
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

        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageView = findViewById<ImageView>(R.id.imageView)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            //Recoge la foto y la muestra por pantalla
            val thumbnail = data?.extras!!.get("data") as Bitmap
            imageView.setImageBitmap(thumbnail)
            // Do other work with full size photo saved in locationForPhotos
        }
    }

    companion object {
        const val REQUEST_IMAGE_CAPTURE = 1
    }
}
