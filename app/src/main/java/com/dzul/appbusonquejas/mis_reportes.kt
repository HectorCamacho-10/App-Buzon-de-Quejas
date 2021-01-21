package com.dzul.appbusonquejas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mis_reportes.*

class mis_reportes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mis_reportes)

        cancelarMisReportes.setOnClickListener {
            val iniciar = Intent (this, nuevavistageneral::class.java)
            startActivity(iniciar)
        }
    }
}