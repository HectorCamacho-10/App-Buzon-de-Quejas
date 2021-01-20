package com.dzul.appbusonquejas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_formulario_reporte.*

class formularioReporte : AppCompatActivity() {
    private val opciones =  arrayOf("A","B","C","D","E","F")
    private  val numero = arrayOf("1","2","3","4","5")
    private var defaltuuy =0
    private var defaltuuyN =0
    private var edificio = ""
    private  var numeroEdificio =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_reporte)
        val textoReporteContenido = findViewById<EditText>(R.id.textoReporte) as EditText

        val btnSi = findViewById<RadioButton>(R.id.radioButtonSi) as RadioButton

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
            if (btnSi.isChecked == false){

                Toast.makeText(this, textoReporteContenido.getText().toString(), Toast.LENGTH_SHORT).show()
                val iniciar = Intent (this, vistageneral::class.java)

                val dialogo =  AlertDialog.Builder(this)
                dialogo.setTitle("Estas Seguro?")
                dialogo.setPositiveButton("ok"){dialog,  _-> dialog.dismiss()
                    startActivity(iniciar)}
                dialogo.setNegativeButton("Cancelar"){dialog, _->dialog.cancel()}
                dialogo.setMessage("Enviaras tus datos")
                 dialogo.show()
            }else{
                val iniciar = Intent (this, vistageneral::class.java)
                startActivity(iniciar)
            }
        }

        buttonCancelar.setOnClickListener(){
            val ini = Intent(this, vistageneral::class.java)
            startActivity(ini)
        }
    }


}