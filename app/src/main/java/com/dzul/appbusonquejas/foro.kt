package com.dzul.appbusonquejas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_foro.*
import kotlinx.android.synthetic.main.activity_foro.Boton_Home
import kotlinx.android.synthetic.main.activity_foro.boton_Foro
import kotlinx.android.synthetic.main.activity_nuevavistageneral.*
import kotlinx.android.synthetic.main.activity_perfil.*

class foro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foro)
        btnRegresar.setOnClickListener {
            val iniciar = Intent (this, nuevavistageneral::class.java)
            startActivity(iniciar)
        }


        //Por alguna razon no puedo ir de Foro a perfil Solo el error en foro
        /*Boton_Perfil.setOnClickListener{
            val iniciar3 = Intent(this, Perfil::class.java)
            startActivity(iniciar3)
        }*/

        boton_Foro.setOnClickListener{
            val iniciar2 = Intent(this, foro::class.java)
            startActivity(iniciar2)
        }


        Boton_Home.setOnClickListener{
            val iniciar2 = Intent(this, nuevavistageneral::class.java)
            startActivity(iniciar2)
        }





    }
}