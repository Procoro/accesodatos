package com.pblazquez.primera.simulacroejer2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class Animaciones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animaciones)

        val btnAnimar = findViewById<Button>(R.id.btnAnimar)
        // Encuentra el ImageView en el layout
        val imageView = findViewById<ImageView>(R.id.imageView)

        // Cargar la animación desde un archivo XML
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.transparency)

        // Aplicar la animación al ImageView

        btnAnimar.setOnClickListener() {
            imageView.startAnimation(animation)
        } // click

    } // fun

} // main