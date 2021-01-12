package com.dzul.appbusonquejas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mis_reportes.*

class misReportes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mis_reportes)

        regresarMenu.setOnClickListener(){
            val ini = Intent(this, vista_general::class.java)
            startActivity(ini)
        }

    }
}