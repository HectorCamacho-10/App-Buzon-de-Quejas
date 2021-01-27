package com.dzul.appbusonquejas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nuevavistageneral.*


enum class ProviderType{
    BASIC
}


class nuevavistageneral : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevavistageneral)

        //setup
        val bundle: Bundle? = intent.extras
        val email: String? = bundle?.getString("email")
        val provider: String? =bundle?.getString("provider")



        setup(email ?: "", provider ?: "")

        boton_mis_reportes.setOnClickListener {
            val iniciar0 = Intent(this, mis_reportes::class.java)
            startActivity(iniciar0)
        }

      boton_anadir_reporte.setOnClickListener{

          val iniciar1 = Intent(this,formularioReporte::class.java).apply {
              putExtra("email", email)
          }
          startActivity(iniciar1)
      }





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
//Email = textview 5
    //provider = provedor textview
    private fun setup(email: String, provider: String){

        textView5.text = email
        ProvedorTextView.text = provider

        /*boton_cerrar_secion.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }*/


    }
}