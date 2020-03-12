package com.touresbalon.producto.ciudad.controlador

import com.touresbalon.producto.ciudad.dto.GetCiudadDto
import com.touresbalon.producto.ciudad.servicio.ServicioCiudad
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("producto/ciudad")
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
class obtenerCiudadController {

    @Autowired
    lateinit var servicioCiudad: ServicioCiudad

    @GetMapping
    fun encontrarCiudadQueContiene(@RequestParam("abreviatura") abreviatura: String): ResponseEntity<Any?> {
        val result = servicioCiudad.encontrarCiudadQueContiene(abreviatura)
        val isNull = result.firstOrNull()
        return when{
            isNull is GetCiudadDto -> ResponseEntity(result, HttpStatus.OK)
            else -> ResponseEntity(result, HttpStatus.NO_CONTENT)
        }
    }

    @GetMapping("all")
    fun obtenerCiudades(): ResponseEntity<Any?> {
        val result = servicioCiudad.obtenerCiudades()
        val isNull = result.firstOrNull()
        return when{
            isNull is GetCiudadDto -> ResponseEntity(result, HttpStatus.OK)
            else -> ResponseEntity(result, HttpStatus.NO_CONTENT)
        }
    }



}