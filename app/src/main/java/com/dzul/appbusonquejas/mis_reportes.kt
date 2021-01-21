package com.dzul.appbusonquejas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.google.firebase.quickstart.database.kotlin.models.bdclase
import kotlinx.android.synthetic.main.activity_mis_reportes.*

class mis_reportes : AppCompatActivity() {
    private lateinit var databasee: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mis_reportes)
        databasee = Firebase.database.reference

        cancelarMisReportes.setOnClickListener {
            val iniciar = Intent (this, nuevavistageneral::class.java)
            startActivity(iniciar)
        }
        Log.d("TAG","*******************************")
        postComment()
    }
    private fun postComment() {
        val datos = arrayListOf<String>()
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                //Consulta
                //val pp= dataSnapshot.child("chat").child("usuario").getValue().toString()
                val pp= dataSnapshot.child("chat").child("usuario")
                // Log.d("TAG",pp[0].toString())
                // ...

                val cuenta = dataSnapshot.child("chat").child("usuario").children.forEach() {
                  val resultado=  pp.child(it.key.toString())
                    val edificio = resultado.child("edificio").getValue().toString()
                    val ubicacion = resultado.child("ubicacion").getValue().toString()
                  datos.add("Poblema : "+it.key.toString()+" Lugar : "+" Edificio: "+edificio+ " Ubicacion posible "+ubicacion)
                }
                val adaptador = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1, datos)
                lst_contenido.adapter = adaptador
               // Log.d("TAG",cuenta.toString() )        // ...
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("TAG", "loadPost:onCancelled", databaseError.toException())
                // ...
            }
        }
        databasee.addValueEventListener(postListener)

    }
}


