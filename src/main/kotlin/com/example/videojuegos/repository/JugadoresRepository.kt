package com.example.videojuegos.repository

import com.example.videojuegos.model.Jugadores
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JugadoresRepository: JpaRepository<Jugadores, Long?> {
    fun findById (id: Long?): Jugadores?

}