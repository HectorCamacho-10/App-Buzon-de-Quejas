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
import kotlinx.android.synthetic.main.activity_actualizar.*
import kotlinx.android.synthetic.main.activity_actualizar.boton_buscar_actualizar
import kotlinx.android.synthetic.main.activity_actualizar.lista_vista_actualizar
import kotlinx.android.synthetic.main.activity_actualizar.rrActualizar
import kotlinx.android.synthetic.main.activity_buscar_reporte.*

class actualizar : AppCompatActivity() {
    private lateinit var databasee: DatabaseReference
    var datos = arrayListOf<String>()
    var buscarDatos = ""
    var problemaHint = ""
    var edificioHint = ""
    var ubicacionHint = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar)
        //boton buscar
        boton_buscar_actualizar.setOnClickListener {

            //Recuperando datos
           buscarDatos= rrActualizar.getText().toString()
            buscar()
            //Metiendo datos a hint
           /* eProblema.setHint(problemaHint)
            eEdificio.setHint(edificioHint)
            eUbicacion.setHint(ubicacionHint)*/

        }
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
                        problemaHint =it.key.toString()
                        val edificio = resultadoo.child("edificio").getValue().toString()
                        val ubicacion = resultadoo.child("ubicacion").getValue().toString()
                        edificioHint = edificio
                        ubicacionHint = ubicacion
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
    private  fun limpiar(){
        datos.clear()
        val adaptador = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1, datos)
        lista_vista_actualizar.adapter = adaptador
    }
}

