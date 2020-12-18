package com.dzul.appbusonquejas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registro.*
import kotlinx.android.synthetic.main.fragment_perfil.*
import kotlin.time.seconds

class Registro: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        registro.setOnClickListener{
            val iniciar = Intent (this, vista_general::class.java)
            startActivity(iniciar)
        }


    }
}