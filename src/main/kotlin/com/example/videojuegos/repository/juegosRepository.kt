package com.example.videojuegos.repository

import com.example.videojuegos.model.Juegos
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JuegosRepository: JpaRepository<Juegos, Long?> {
    fun findById (id: Long?): Juegos?

}
