package com.dzul.appbusonquejas
import android.animation.Animator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ActivityNavigator
import kotlinx.android.synthetic.main.activity_foro.*
import kotlinx.android.synthetic.main.activity_foro.Boton_Home
import kotlinx.android.synthetic.main.activity_foro.boton_Foro
import kotlinx.android.synthetic.main.activity_nuevavistageneral.*
import kotlinx.android.synthetic.main.activity_perfil.*

class foro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_foro)

        ActivityNavigator.applyPopAnimationsToPendingTransition(this)

        btnRegresar.setOnClickListener {
            val iniciar = Intent (this, nuevavistageneral::class.java)
            startActivity(iniciar)
        }



        boton_Foro.setOnClickListener{
            val iniciar2 = Intent(this, foro::class.java)
            startActivity(iniciar2)


        }


        Boton_Home.setOnClickListener{
            val iniciar2 = Intent(this, nuevavistageneral::class.java)
            startActivity(iniciar2)
        }

       imageButton2.setOnClickListener{
           val iniciar3 = Intent( this, Perfil::class.java)
           startActivity(iniciar3)

           //Animatoo.animateZoom(context);
}

        }


}