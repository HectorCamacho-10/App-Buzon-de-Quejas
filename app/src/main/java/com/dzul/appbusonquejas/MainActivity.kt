package com.dzul.appbusonquejas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.appcompat.app.AlertDialog

import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //setTheme(R.style.AppTheme) //SplashSecreen

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Logeo para proceder a iniciar el otro activity -Esto es temporal solo para ver el funcinamieto de la itnerfass
        log_in.setOnClickListener {
            val iniciar = Intent(this, nuevavistageneral::class.java)
            startActivity(iniciar)*/

           setup()
          // showhome(email = String(), provider = ProviderType.BASIC)
           //alerta()
        }
       /////////////////////////////



    private fun setup(){

////////////////////////////////////////////////////////////////////////////////////////////////////////
        boton_registrarce.setOnClickListener{

            if (editText_correo.text.isNotEmpty() && editText_password.text.isNotEmpty()){ //Si no esta vacio los text se podra registrar

               FirebaseAuth.getInstance()
                   .createUserWithEmailAndPassword(editText_correo.text.toString(),
                       editText_password.text.toString()).addOnCompleteListener() {

                 if(it.isSuccessful){
                     showhome(it.result?.user?.email ?: "", ProviderType.BASIC)

                 }else{
                     alerta()
                 }
               }
            }

    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////
        boton_iniciar_secion.setOnClickListener{

            if (editText_correo.text.isNotEmpty() && editText_password.text.isNotEmpty()){ //Si no esta vacio los text se podra registrar

                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(editText_correo.text.toString(),
                        editText_password.text.toString()).addOnCompleteListener() {

                    if(it.isSuccessful){
                        showhome(it.result?.user?.email ?: "", ProviderType.BASIC)

                    }else{
                        alerta()
                    }
                }
            }

        }


    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private fun alerta(){ //Mensaje de error dentro de una variable privada que se llama en el else
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ah producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()

    }

    private fun showhome(email: String, provider: ProviderType){

        val homeintent:Intent = Intent(this, nuevavistageneral::class.java).apply {

            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeintent)
    }


}










