package com.example.videojuegos.model

import jakarta.persistence.*

@Entity
@Table(name = "jugadores")
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