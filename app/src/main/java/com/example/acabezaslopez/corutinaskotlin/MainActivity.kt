package com.example.acabezaslopez.corutinaskotlin

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
// extension para referenciar los elementos del layout
import kotlinx.android.synthetic.main.activity_main.*
// para las corutinas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
// para las corutinas, a partir de cuatro imports del mismo paquete, ponemos "*"
import kotlinx.coroutines.*
import kotlinx.coroutines.launch

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cuando le damos al boton empezamos una corutina
        botoncuentaatras.setOnClickListener{cuentaAtras(it)}
    }

    /** Cuenta atras en el TextView con id miTexto
    * @param v boton que hace el click
    */
    fun cuentaAtras(v: View) {
        val botonAux = v as Button
        // lanza la corutina en el hilo principal
        GlobalScope.launch(Dispatchers.Main) {
            // cuenta atras 10 a 1
            for (i in 50 downTo 1) {
                // actualiza TextView
                miTexto.text = "$i"
                Log.d("ejemploco", i.toString())
                // paramos la corutina 0,5sg
                // ATENCIÓN: No para el hilo principal
                delay(500)
            }
            miTexto.text = "Boom!"
        }
    }
}