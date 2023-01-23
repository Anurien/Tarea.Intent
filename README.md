# Tarea: Intent

En este repositorio veremos como hacer una aplicación para practicar ejercicios con Intents en la que se abre la camara de fotos del movil y se recoge la imagen a la 
aplicación. Además tambien te permite comprobar si la suma de dos números aleatorios está bien realizada.

Así se vería la MainActivity antes y despues de recibir la foto de la cámara:

![imagen](https://user-images.githubusercontent.com/91197967/214013634-7d1bd58f-7ebc-4376-b336-32d07fa432dc.png)
![imagen](https://user-images.githubusercontent.com/91197967/214013416-b59ca09f-3e1e-49ac-95c7-bead3c7e724b.png)


La selección del resultado está realizada con un Spinner (no óptimo para este ejercicio) que necesita un adaptador para sacar el array de numeros
por pantalla y un layout para que las opciones del array salgan por pantalla. Los layouts del spinner son predeterminados de Kotlin.
Aquí un ejemplo simple del código:

```
  var spinner = findViewById<Spinner>(R.id.spinner_sample)
        // Crea un ArrayAdapter usando un simple spinner layout y el array de numeros
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, numeros)
        // pone un layout para las opciones que vayan a salir
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Asociar el adaptador al spinner
        spinner!!.setAdapter(aa)
```
Para recoger el resultado del spinner simplemente recoger la posicion del item seleccionado en el Spinner:
```
  val numPosition = spinner.selectedItemPosition
  val valornum = numeros.get(numPosition)
```

Aqui una imagen de como fue realizada la SecondActivity:

![imagen](https://user-images.githubusercontent.com/91197967/214014052-d5693951-20e3-4d30-934a-723cc2d6b1e7.png)
![imagen](https://user-images.githubusercontent.com/91197967/214013965-9b818298-5ae4-4af3-99f5-a318e174c1ab.png)


        

