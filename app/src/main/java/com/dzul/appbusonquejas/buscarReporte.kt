package com.dzul.appbusonquejas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_buscar_reporte.*

class buscarReporte : AppCompatActivity() {
    private lateinit var databasee: DatabaseReference
    var datos = arrayListOf<String>()
    var buscarDatos = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_reporte)
        databasee = Firebase.database.reference


        boton_buscar_actualizar.setOnClickListener {
            val recursoTexto = rrActualizar.getText().toString()
            if(recursoTexto != ""){
                buscarDatos = recursoTexto
                Toast.makeText(this, "Bucando : "+recursoTexto, Toast.LENGTH_SHORT).show()
                buscar()
                limpiar()
            }else{
                Toast.makeText(this, "No escribiste nada para buscar", Toast.LENGTH_SHORT).show()
                postComment()
            }

        }
    }

    private fun postComment() {

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
                lista_vista_actualizar.adapter = adaptador
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
    private  fun limpiar(){
        datos.clear()
        val adaptador = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1, datos)
        lista_vista_actualizar.adapter = adaptador
    }
    private fun buscar(){
        var int = false
        val encontrar = object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val ppp= snapshot.child("chat").child("usuario")
                val pp= snapshot.child("chat").child("usuario").children.forEach(){
                    val resultado=  it.key.toString()
                    if(buscarDatos ==  resultado){
                        int= true
                        val resultadoo=  ppp.child(it.key.toString())
                        val edificio = resultadoo.child("edificio").getValue().toString()
                        val ubicacion = resultadoo.child("ubicacion").getValue().toString()

                        datos.add("Poblema : "+it.key.toString()+" Lugar : '\n'"+" Edificio: \n"+edificio+ " Ubicacion posible :\n"+ubicacion)
                        Log.d("TAG", "encontrado")
                    }

                }
                if(int == false){
                    Log.d("TAG", "NO encontrado")
                    Log.d("TAG", int.toString())
                    Toast.makeText(applicationContext, "No se encontro resultados", Toast.LENGTH_SHORT).show()
                    limpiar()
                }else{
                    val adaptador = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1, datos)
                    lista_vista_actualizar.adapter = adaptador
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        }
        databasee.addValueEventListener(encontrar)
    }
    private fun aniadir(){

    }
}