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
import com.google.firebase.quickstart.database.kotlin.models.bdclase
import com.google.firebase.quickstart.database.kotlin.models.com.dzul.appbusonquejas.ac
import kotlinx.android.synthetic.main.activity_actualizar.*
import kotlinx.android.synthetic.main.activity_actualizar.lista_vista_actualizar
import kotlinx.android.synthetic.main.activity_buscar_reporte.*
import kotlinx.android.synthetic.main.activity_busqueda_actividad.*

class busquedaActividad : AppCompatActivity() {
    private lateinit var databasee: DatabaseReference
    var datos = arrayListOf<String>()
    var buscarDatoss = ""
    var hintProblema = "Problema"
    var hintEdificio ="Edificio"
    var hintUbicacion = "Ubicacion"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busqueda_actividad)
        databasee = Firebase.database.reference
        botonBuscarRecurso.setOnClickListener {
            limpiar()
           val rrBc= recursoBusquedaActualiza.getText().toString()
            if(rrBc != ""){

                buscarDatoss = rrBc
                Toast.makeText(this, "Buscando", Toast.LENGTH_SHORT).show()
                buscarr()
                eeProblema.setHint(hintProblema)
                eeUbicacio.setHint(hintUbicacion)
                eeEdificio.setHint(hintEdificio)

                    botonActualizar.setOnClickListener {
                        actualizar()
                        limpiar()
                        Toast.makeText(this, "Se actualizo "+buscarDatoss, Toast.LENGTH_SHORT).show()

                        buscarr()

                }
                botonEliminar.setOnClickListener {
                    eliminar()
                    limpiar()
                    Toast.makeText(this, "has eliminado"+buscarDatoss, Toast.LENGTH_SHORT).show()
                    buscarr()
                }



            }else{
                Toast.makeText(this, "No escribiste nada para buscar", Toast.LENGTH_SHORT).show()
                ec()

            }
        }
    }
    private fun ec() {
        val bbb = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val pp= snapshot.child("chat").child("usuario")
                val cuenta = snapshot.child("chat").child("usuario").children.forEach() {
                    val resultado=  pp.child(it.key.toString())
                    val edificio = resultado.child("edificio").getValue().toString()
                    val ubicacion = resultado.child("ubicacion").getValue().toString()
                    datos.add("Poblema : "+it.key.toString()+" Lugar : "+" Edificio: "+edificio+ " Ubicacion posible "+ubicacion)
                }
                val adaptador = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1, datos)
                listaEnActualiza.adapter = adaptador
                // Log.d("TAG",cuenta.toString() )        // ...
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        databasee.addValueEventListener(bbb)
    }

    private fun buscarr(){
        var int = false
        val encontrar = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val ppp= snapshot.child("chat").child("usuario")
                val pp= snapshot.child("chat").child("usuario").children.forEach(){
                    val resultado=  it.key.toString()
                    if(buscarDatoss ==  resultado){
                        int= true
                        val resultadoo=  ppp.child(it.key.toString())
                        val edificio = resultadoo.child("edificio").getValue().toString()
                        val ubicacion = resultadoo.child("ubicacion").getValue().toString()
                        hintProblema = it.key.toString()
                        hintEdificio = edificio
                        hintUbicacion = ubicacion
                        datos.add("Poblema : "+it.key.toString()+"\n Lugar : \n"+" \nEdificio: \n"+edificio+ " \nUbicacion posible :\n"+ubicacion)
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
                    listaEnActualiza.adapter = adaptador
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        }
        databasee.addValueEventListener(encontrar)
    }
    private  fun limpiar(){
        datos.clear()
        val adaptador = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1, datos)
        listaEnActualiza.adapter = adaptador
    }
    private fun actualizar(){
        val bn = ac(eeEdificio.getText().toString(),eeUbicacio.getText().toString())
        databasee.child("chat").child("usuario").child(buscarDatoss).setValue(bn)
    }
    private fun eliminar(){
        databasee.child("chat").child("usuario").child(buscarDatoss).removeValue()
    }
}