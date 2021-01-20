package com.dzul.appbusonquejas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_nuevavistageneral.*

class nuevavistageneral : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevavistageneral)


        boton_mis_reportes.setOnClickListener {
            val iniciar = Intent(this, misReportes::class.java)
            startActivity(iniciar)
        }

      boton_anadir_reporte.setOnClickListener{
          val iniciar1 = Intent(this,formularioReporte::class.java)
          startActivity(iniciar1)
      }

        //Aqui Boton Foro (Crear nuevo activity Foro necedsario)


        boton_foro.setOnClickListener{
            val iniciar2 = Intent(this, foro::class.java)
            startActivity(iniciar2)
        }
        //Aqui boton Perfil Aun no creado Activity (Perfil no necesario)


    }
}