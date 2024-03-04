package com.pblazquez.primera.simulacroejer2


import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class Cursos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cursos)

        val videoView = findViewById<VideoView>(R.id.video_view)

        // Especifica la ruta del video
        var videoPath = "android.resource://${packageName}/${R.raw.vddron}"
        var videoUri = Uri.parse(videoPath)

        // Configura el VideoView para reproducir el video
        videoView.setVideoURI(videoUri)

        // Configura los controles de reproducción del video
        val mediaController = android.widget.MediaController(this)
        videoView.setMediaController(mediaController)
        mediaController.setAnchorView(videoView)

        val btn1 = findViewById<Button>(R.id.btn_v1)
        btn1.setOnClickListener {
            videoPath = "android.resource://${packageName}/${R.raw.vddron}"
            videoUri = Uri.parse(videoPath)

            // Configura el VideoView para reproducir el video
            videoView.setVideoURI(videoUri)
            videoView.seekTo(0)
            videoView.start()
            Toast.makeText(applicationContext, "Reproduciendo video 1", Toast.LENGTH_LONG).show()
        } // click

        val btn2 = findViewById<Button>(R.id.btn_v2)
        btn2.setOnClickListener {
            videoPath = "android.resource://${packageName}/${R.raw.vdpelea}"
            videoUri = Uri.parse(videoPath)

            // Configura el VideoView para reproducir el video
            videoView.setVideoURI(videoUri)
            videoView.start()
            Toast.makeText(applicationContext, "Reproduciendo video 2", Toast.LENGTH_LONG).show()
        } // click

        val btn3 = findViewById<Button>(R.id.btn_v3)
        btn3.setOnClickListener {
            videoPath = "android.resource://${packageName}/${R.raw.vdmusic}"
            videoUri = Uri.parse(videoPath)

            // Configura el VideoView para reproducir el video
            videoView.setVideoURI(videoUri)
            videoView.start()
            Toast.makeText(applicationContext, "Reproduciendo video 3", Toast.LENGTH_LONG).show()
        } // click
    } // fun
} // class