package com.touresbalon.producto.ciudad.controlador

import com.touresbalon.producto.ciudad.dto.GetCiudadDto
import com.touresbalon.producto.ciudad.dto.RespuestaDto
import com.touresbalon.producto.ciudad.servicio.ServicioCiudad
import com.touresbalon.producto.ciudad.valueObject.CiudadVo
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
    fun encontrarCiudadPor(@RequestParam("abv") abreviatura: String): ResponseEntity<Any?> {
        var ciudad = CiudadVo(abreviatura)
        var validaCiudad = ciudad.validaString()
        return when {
            validaCiudad is String -> {
                val respuesta = RespuestaDto()
                respuesta.mensaje = validaCiudad
                ResponseEntity<Any?>(respuesta, HttpStatus.BAD_REQUEST)
            }
            else -> encontrarCiudadDesdeServicioPor(ciudad.getToLowerCase())
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

    /**
     * Metodo que desde el servicio inicia la consulta de ciudades que contengan la abreviatura
     */
    private fun encontrarCiudadDesdeServicioPor(abreviatura: String): ResponseEntity<Any?>{
        val result = servicioCiudad.encontrarCiudadQueContiene(abreviatura)
        val isNull = result.firstOrNull()
        return when {
            isNull is GetCiudadDto -> ResponseEntity(result, HttpStatus.OK)
            else -> ResponseEntity(result, HttpStatus.NO_CONTENT)
        }
    }

}