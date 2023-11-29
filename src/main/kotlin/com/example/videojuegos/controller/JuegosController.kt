package com.example.videojuegos.controller

import com.example.videojuegos.model.Juegos
import com.example.videojuegos.service.juegosService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/juegos")   //endpoint

@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class JuegosController {
    @Autowired
    lateinit var juegosService: juegosService


    @GetMapping
    fun list ( ):List <Juegos>{
        return juegosService.list()
    }

    @PostMapping
    fun save (@RequestBody @Valid juegos:Juegos):ResponseEntity<Juegos>{
        return ResponseEntity(juegosService.save(juegos), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody juegos: Juegos):ResponseEntity<Juegos>{
        return ResponseEntity(juegosService.update(juegos), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody juegos: Juegos):ResponseEntity<Juegos>{
        return ResponseEntity(juegosService.updateName(juegos), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(juegosService.listById (id), HttpStatus.OK)

    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return juegosService.delete(id)
    }
}