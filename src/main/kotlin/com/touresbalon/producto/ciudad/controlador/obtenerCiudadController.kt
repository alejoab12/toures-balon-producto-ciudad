package com.touresbalon.producto.ciudad.controlafor

import com.touresbalon.producto.ciudad.dto.GetCiudadDto
import com.touresbalon.producto.ciudad.entidad.Ciudad
import com.touresbalon.producto.ciudad.servicio.ServicioCiudad
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.lang.Nullable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class obtenerCiudadController {

    @Autowired
    lateinit var servicioCiudad: ServicioCiudad

    @GetMapping("producto/ciudad")
    fun encontrarCiudadQueContiene(@RequestParam("abreviatura") abreviatura: String): ResponseEntity<Any?> {
        val result = servicioCiudad.encontrarCiudadQueContiene(abreviatura)
        val isNull = result.firstOrNull()
        return when{
            isNull is GetCiudadDto -> ResponseEntity(result, HttpStatus.OK)
            else -> ResponseEntity(result, HttpStatus.NO_CONTENT)
        }
    }

    @GetMapping("producto/ciudad/todo")
    fun obtenerCiudades(): ResponseEntity<Any?> {
        val result = servicioCiudad.obtenerCiudades()
        val isNull = result.firstOrNull()
        return when{
            isNull is GetCiudadDto -> ResponseEntity(result, HttpStatus.OK)
            else -> ResponseEntity(result, HttpStatus.NO_CONTENT)
        }
    }



}