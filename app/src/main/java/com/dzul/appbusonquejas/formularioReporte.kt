package com.dzul.appbusonquejas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.quickstart.database.kotlin.models.bdclase
import kotlinx.android.synthetic.main.activity_formulario_reporte.*

class formularioReporte : AppCompatActivity() {
    private val opciones =  arrayOf("A","B","C","D","E","F")
    private  val numero = arrayOf("1","2","3","4","5")
    private var defaltuuy =0
    private var defaltuuyN =0
    private var edificio = ""
    private  var numeroEdificio =""
    private lateinit var databasee: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_reporte)
        val textoReporteContenido = findViewById<EditText>(R.id.textoReporte) as EditText

        val btnSi = findViewById<RadioButton>(R.id.radioButtonSi) as RadioButton
        databasee = Firebase.database.reference

        btnSi.setOnClickListener(){
            textViewEdificio.isVisible = true
            textViewEdificio.text = "A"
            edificio =  "A"
            buttonAniadir.isVisible = false
           val bui= AlertDialog.Builder(this)
            bui.setTitle("Edificio")
            bui.setPositiveButton("Ok")  { dialog, _ -> dialog.dismiss() }
            bui.setSingleChoiceItems(opciones, defaltuuy){_, which ->
               defaltuuy = which
                edificio =  opciones[which]

                textViewEdificio.text = opciones[which]
                Toast.makeText(this, opciones[which], Toast.LENGTH_SHORT).show()
            }
            bui.show()
            grupoDos.isVisible = true
        }

        radioButtonAula.setOnClickListener(){

            inputNombre.isVisible =false
            textViewNombre.isVisible = true
            textViewEdificio.text = "1"
            numeroEdificio = "1"
            val opcionesAula = AlertDialog.Builder(this)
            val nombrecorrecto = "Numero de edificio "+ edificio
            opcionesAula.setTitle(nombrecorrecto)

            opcionesAula.setPositiveButton("ok"){dialog, _-> dialog.dismiss()}
            opcionesAula.setSingleChoiceItems(numero, defaltuuyN){_, which ->
                defaltuuyN = which

                numeroEdificio= numero[which]
                textViewNombre.text = numero[which]
            }

            opcionesAula.show()

        }

        radioButtonSala.setOnClickListener(){
            textViewNombre.isVisible = false
            inputNombre.isVisible =true
            buttonAniadir.isVisible = true
        }
        radioButtonNo.setOnClickListener(){
            textViewEdificio.isVisible = false
            textViewNombre.isVisible = false
            grupoDos.isVisible = false
            inputNombre.isVisible =false
            buttonAniadir.isVisible = true

        }
        buttonAniadir.setOnClickListener(){
            val bundle: Bundle? = intent.extras
            val email: String? = bundle?.getString("email")
            val bd  = bdclase("usuario",textoReporteContenido.getText().toString(),edificio,numeroEdificio)
            databasee.child("chat").child(bd.usuario.toString()).child(textoReporteContenido.getText().toString()).setValue(bd).addOnCanceledListener{
                databasee.push().key
            }



            if (btnSi.isChecked == false){

                Toast.makeText(this, textoReporteContenido.getText().toString(), Toast.LENGTH_SHORT).show()
                val iniciar = Intent (this, nuevavistageneral::class.java)

                val dialogo =  AlertDialog.Builder(this)
                dialogo.setTitle("Estas Seguro?")
                dialogo.setPositiveButton("ok"){dialog,  _-> dialog.dismiss()
                    startActivity(iniciar)}
                dialogo.setNegativeButton("Cancelar"){dialog, _->dialog.cancel()}
                dialogo.setMessage("Enviaras tus datos")
                 dialogo.show()

            /*.setValue(textoReporteContenido.getText().toString())*/

            }else{

                val iniciar = Intent (this, nuevavistageneral::class.java)
                startActivity(iniciar)
            }
        }

        buttonCancelar.setOnClickListener(){

            val ini = Intent(this, nuevavistageneral::class.java)
            startActivity(ini)
        }
    }


}