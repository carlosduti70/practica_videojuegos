package com.example.videojuegos.service

import com.example.videojuegos.model.Juegos
import com.example.videojuegos.model.Jugadores
import com.example.videojuegos.repository.JuegosRepository
import com.example.videojuegos.repository.JugadoresRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class JugadoresService {
    @Autowired
    lateinit var jugadoresRepository: JugadoresRepository

    @Autowired
    lateinit var juegosRepository: JuegosRepository
    fun list ():List<Jugadores>{
        return jugadoresRepository.findAll()
    }

//post
    fun save(jugadores: Jugadores): Jugadores {
        try{
            jugadores.nombre?.takeIf {it.trim().isNotEmpty()}
                    ?:throw Exception("Nombre no debe ser vacio")
            jugadores.genero?.takeIf {it.trim().isNotEmpty()}
                    ?:throw Exception("genero no debe ser vacio")
            juegosRepository.findById(jugadores.juegosId)
                    ?:throw Exception("id no existe")
            return jugadoresRepository.save(jugadores)



        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.BAD_REQUEST,ex.message)
        }
    }
    //put
    fun update(jugadores: Jugadores): Jugadores {
        try {
            jugadoresRepository.findById(jugadores.id)
                    ?: throw Exception("ID no existe")

            return jugadoresRepository.save(jugadores)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(jugadores: Jugadores): Jugadores {
        try{
            val response = jugadoresRepository.findById(jugadores.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                nombre=jugadores.nombre //un atributo del modelo
            }
            return jugadoresRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun listById (id:Long?): Jugadores?{
        return jugadoresRepository.findById(id)
    }

    fun delete (id: Long?):Boolean?{
        try{
            val response = juegosRepository.findById(id)
                    ?: throw Exception("ID no existe")
            juegosRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}