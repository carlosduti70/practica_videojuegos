package com.example.videojuegos.controller

import com.example.videojuegos.model.Juegos
import com.example.videojuegos.model.Jugadores
import com.example.videojuegos.service.JugadoresService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/jugadores")   //endpoint

class JugadoresController {
    @Autowired
    lateinit var jugadoresService: JugadoresService

    @GetMapping
    fun list ():List <Jugadores>{
        return jugadoresService.list()
    }

    @PostMapping
    fun save (@RequestBody jugadores: Jugadores): ResponseEntity<Jugadores> {
        return ResponseEntity(jugadoresService.save(jugadores), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody jugadores: Jugadores): ResponseEntity<Jugadores> {
        return ResponseEntity(jugadoresService.update(jugadores), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody jugadores: Jugadores): ResponseEntity<Jugadores> {
        return ResponseEntity(jugadoresService.updateName (jugadores), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(jugadoresService.listById (id), HttpStatus.OK)

    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return jugadoresService.delete(id)
    }
}