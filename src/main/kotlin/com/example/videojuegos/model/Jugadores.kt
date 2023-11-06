package com.example.videojuegos.model

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

class Jugadores {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nombre: String? = null
    var genero: String? = null
    var edad: Long?= null
    @Column(name= "juegos_id")
    var juegosId: Long? = null
}