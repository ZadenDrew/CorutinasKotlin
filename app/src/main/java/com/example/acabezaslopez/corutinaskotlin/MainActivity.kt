package com.example.acabezaslopez.corutinaskotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.acabezaslopez.corutinaskotlin.R.id.botonFecha
import kotlinx.android.synthetic.main.activity_main.*
// para las corutinas, a partir de cuatro imports del mismo paquete, ponemos "*"
import kotlinx.coroutines.*
import org.jetbrains.anko.toast
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botonFecha.setOnClickListener { cambiarMensaje(it) }
    }

    /**
     * Sustituye la fecha en el TextView con id Fecha
     * @param cuadro de texto para la fecha del click
     */
    fun cambiarMensaje(v: View) {
        val botonAux = v as Button
        val fechaActual = Calendar.getInstance().getTime()
        fecha.text = fechaActual.toString()
        toast("Lambda en " + botonAux.text)
    }

    private suspend fun setTextAfterDelay(seconds: Long, text: String) {
        delay(seconds)
        fecha.text = text
    }
}