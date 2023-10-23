package com.example.videojuegos.service

import com.example.videojuegos.model.Juegos
import com.example.videojuegos.repository.JuegosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class juegosService {
    @Autowired
    lateinit var juegosRepository: JuegosRepository
//list
    fun list ():List<Juegos>{
        return juegosRepository.findAll()
    }

//post

    fun save(juegos:Juegos): Juegos {
        try{
            return juegosRepository.save(juegos)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
//put
    fun update(juegos: Juegos): Juegos{
        try {
            juegosRepository.findById(juegos.id)
                    ?: throw Exception("ID no existe")

            return juegosRepository.save(juegos)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(juegos: Juegos): Juegos{
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

    fun listById (id:Long?):Juegos?{
        return juegosRepository.findById(id)
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

//pollo