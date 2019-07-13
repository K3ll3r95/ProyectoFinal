package com.example.farmachinchanito.models

class Pastilla{
    var nom : String?  =""
    var img: String? =""
    var Precio: Double? = 0.0
    var descripcion: String? =""
    constructor(){

    }
    constructor( nom : String?,
                 img: String?,
                 Precio: Double?,
                 descripcion: String? ){
        this.nom = nom
        this.img = img
        this.Precio = Precio
        this.descripcion = descripcion
    }

}