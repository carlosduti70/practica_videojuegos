package com.example.videojuegos.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "juegos")
class Juegos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var titulo: String? = null
    var plataforma: String? = null
    @Column(name="ano_lanzamiento")
    var anoLanzamiento: Int? = null
    @Column(name= "puntuacion_media")
    var puntuacionMedia: Float? = null
}