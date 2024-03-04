package com.pblazquez.primera.simulacroejer2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar



class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etPass = findViewById<EditText>(R.id.etPass)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnCurs = findViewById<Button>(R.id.btnCurs)
        val btnAnim = findViewById<Button>(R.id.btnAnim)
        val btnInflate = findViewById<Button>(R.id.btnInflate)

        btnLogin.setOnClickListener() {
            val nombre = etNombre.text.toString()
            val fecha = Calendar.getInstance().time
            val nombreArchivo = "login.txt"
            val contenido = "$nombre\n$fecha"

            // Escribe y guarda el archivo en el directorio de la aplicación en "files".
            openFileOutput(nombreArchivo, Context.MODE_PRIVATE).use {
                it.write(contenido.toByteArray())
            } // use
            Toast.makeText(this, "Archivo guardado correctamente!", Toast.LENGTH_SHORT).show()
        } // click

        btnCurs.setOnClickListener() {
            // Cambio de pantalla
            val intent = Intent(this, Cursos::class.java)
            startActivity(intent)
        } // click

        btnAnim.setOnClickListener() {
            // Cambio de pantalla
            val intent = Intent(this, Animaciones::class.java)
            startActivity(intent)
        } // click

        btnInflate.setOnClickListener() {
            // Cambio de pantalla
            val intent = Intent(this, LayoutInflater::class.java)
            startActivity(intent)
        } // click
    } // fun
} // class