package com.pblazquez.primera.simulacroejer2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pblazquez.primera.simulacroejer2.R

class LayoutInflater : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_inflater)
        // Inflar el diseño XML
        val rootView: View = LayoutInflater.from(this).inflate(R.layout.activity_layout_inflater, null)

        // Obtener referencia al linearLayout (puedes usar el tipo de layout que estés utilizando)
        val linearLayout = rootView.findViewById<LinearLayout>(R.id.linearLayoutContainer)
        val btnRojo = findViewById<Button>(R.id.btnRojo)
        // Listener del botón
        btnRojo.setOnClickListener() {
            // Crear un nuevo TextView dinámicamente
            val nuevoTextView = TextView(this)
            // Establecemos valores visuales al botón(XML).
            nuevoTextView.textSize = 20F
            nuevoTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER
            nuevoTextView.text = "LayoutInflater funciona correctamente."

            // Agregar el nuevo TextView al contenedor
            linearLayout.addView(nuevoTextView)
            // Establecer la vista inflada en la actividad
            setContentView(rootView)
        } // click
    } // fun
} // class