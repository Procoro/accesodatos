package com.pblazquez.primera.simulacro

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pblazquez.primera.simulacro.DataManager

class MainActivity : AppCompatActivity() {

    private lateinit var dataManager: DataManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataManager = DataManager(this)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etApellidos = findViewById<EditText>(R.id.etApellidos)
        val etDireccion = findViewById<EditText>(R.id.etDireccion)
        val etCP = findViewById<EditText>(R.id.etCP)
        val etCiudad = findViewById<EditText>(R.id.etCiudad)
        val etProvincia = findViewById<EditText>(R.id.etProvincia)
        val etTelefono = findViewById<EditText>(R.id.etTelefono)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        val btnMostrar = findViewById<Button>(R.id.btnMostrar)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)
        val tvMuestraNombre = findViewById<TextView>(R.id.tvMuestraNombre)

        btnAgregar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val apellidos = etApellidos.text.toString()
            val direccion = etDireccion.text.toString()
            val cp = etCP.text.toString().toInt()
            val ciudad = etCiudad.text.toString()
            val provincia = etProvincia.text.toString()
            val telefono = etTelefono.text.toString().toInt()
            dataManager.addData(nombre, apellidos, direccion, cp, ciudad, provincia, telefono)
            Toast.makeText(
                this,
                "Se agregó a la base de datos todos los valores de: $nombre, $apellidos",
                Toast.LENGTH_SHORT
            ).show()
            etNombre.text.clear()
            etApellidos.text.clear()
            etDireccion.text.clear()
            etCP.text.clear()
            etCiudad.text.clear()
            etProvincia.text.clear()
            etTelefono.text.clear()
        }

        btnMostrar.setOnClickListener {
            val data = dataManager.getAllData(this)
            tvMuestraNombre.text = data
        }

        btnBorrar.setOnClickListener {
            dataManager.eliminateData()
            Toast.makeText(
                this,
                "Se han borrado todoslos registros",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
