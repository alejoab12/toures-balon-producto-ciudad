package com.touresbalon.producto.ciudad.controlafor

import com.touresbalon.producto.ciudad.dto.CiudadDto
import com.touresbalon.producto.ciudad.dto.RegistroCiudadDto
import com.touresbalon.producto.ciudad.dto.RespuestaDto
import com.touresbalon.producto.ciudad.servicio.ServicioCiudad
import com.touresbalon.producto.ciudad.valueObject.CiudadVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RegistroCiudadController {

    @Autowired
    lateinit var servicioCiudad: ServicioCiudad

    @PostMapping("producto/ciudad")
    fun registrarCiudadDesde(@RequestBody registroCiudadDto: RegistroCiudadDto): ResponseEntity<Any?> {
        return validaCiudad(registroCiudadDto)
    }

    /**
     * Metodo que valida los atributos de request sobre #RegistroDto
     * atributos validados
     * ciudad
     */
    private fun validaCiudad(registroCiudadDto: RegistroCiudadDto): ResponseEntity<Any?> {
        var ciudad = CiudadVo(registroCiudadDto.ciudad)
        var validaCiudad = ciudad.validaString()
        return when {
            validaCiudad is String -> {
                val respuesta = RespuestaDto()
                respuesta.mensaje = validaCiudad
                ResponseEntity<Any?>(respuesta, HttpStatus.BAD_REQUEST)
            }
            else -> {
                val ciudadDto = CiudadDto()
                ciudadDto.ciudad = ciudad
                ciudadDto.construyeCiudadDto(registroCiudadDto)
                servicioCiudad.registrarCiudadDesde(ciudadDto)
                ResponseEntity<Any?>(null, HttpStatus.CREATED)
            }
        }
    }

}