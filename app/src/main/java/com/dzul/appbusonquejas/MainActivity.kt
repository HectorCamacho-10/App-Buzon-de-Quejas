package com.dzul.appbusonquejas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dzul.appbusonquejas.ui.home.HomeFragment
import com.dzul.appbusonquejas.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme) //SplashSecreen

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Logeo para proceder a iniciar el otro activity -Esto es temporal solo para ver el funcinamieto de la itnerfass
        log_in.setOnClickListener {
            val iniciar = Intent(this, nuevavistageneral::class.java)
            startActivity(iniciar)
        }



    }
}










