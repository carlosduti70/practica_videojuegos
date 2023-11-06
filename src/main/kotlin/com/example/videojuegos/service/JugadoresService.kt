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
            juegosRepository.findById(jugadores.juegosId)
                    ?: throw Exception("Id del cliente no encontrada")
            return jugadoresRepository.save(jugadores)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    //put
    fun update(juegos: Juegos): Juegos {
        try {
            juegosRepository.findById(juegos.id)
                    ?: throw Exception("ID no existe")

            return juegosRepository.save(juegos)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(juegos: Juegos): Juegos {
        try{
            val response = juegosRepository.findById(juegos.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                plataforma=juegos.plataforma //un atributo del modelo
            }
            return juegosRepository.save(response)
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