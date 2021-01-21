package com.google.firebase.quickstart.database.kotlin.models
import com.google.firebase.database.IgnoreExtraProperties
@IgnoreExtraProperties
data class bdclase (
     var usuario : String? = "",
      var reporte : String?="",
    var edificio : String?="",
      var ubicacion: String?="")

/*
    constructor(usuario: String?, reporte: String?, edificio: String?, ubicacion: String?) {
        this.usuario = usuario
        this.reporte = reporte
        this.edificio = edificio
        this.ubicacion = ubicacion
    }*/


