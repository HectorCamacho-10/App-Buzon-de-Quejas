package com.dzul.appbusonquejas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nuevavistageneral.*

class Perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)




        boton_Foro.setOnClickListener{
            val iniciar2 = Intent(this, foro::class.java)
            startActivity(iniciar2)
        }
        //Aqui boton Perfil Aun no creado Activity (Perfil no necesario)

        Boton_Home.setOnClickListener{
            val iniciar2 = Intent(this, nuevavistageneral::class.java)
            startActivity(iniciar2)
        }


        boton_Perfil.setOnClickListener{
            val iniciar3 = Intent(this, Perfil::class.java)
            startActivity(iniciar3)
        }
    }
}