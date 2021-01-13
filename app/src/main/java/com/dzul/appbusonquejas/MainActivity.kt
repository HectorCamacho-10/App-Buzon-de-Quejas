package com.dzul.appbusonquejas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registro.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme) //SplashSecreen

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Logeo para proceder a iniciar el otro activity -Esto es temporal solo para ver el funcinamieto de la itnerfass
        log_in.setOnClickListener {
            val iniciar = Intent(this, vista_general::class.java)
            startActivity(iniciar)
        }

        registrarce.setOnClickListener {
            val iniciar_r = Intent(this, registro::class.java) //Problema con xml de registrarce
            startActivity(iniciar_r)
            }

    }
}










