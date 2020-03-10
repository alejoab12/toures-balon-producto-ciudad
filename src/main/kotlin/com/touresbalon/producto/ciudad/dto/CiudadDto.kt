package com.touresbalon.producto.ciudad.dto

import com.touresbalon.producto.ciudad.valueObject.CiudadVo

class CiudadDto {
    lateinit var ciudad: CiudadVo
    lateinit var codigoCiudad: String
    lateinit var codigoPais: String
    lateinit var estado: String
    lateinit var pais: String

    fun construyeCiudadDto(registroCiudadDto: RegistroCiudadDto){
        codigoCiudad = registroCiudadDto.codigoCiudad
        codigoPais = registroCiudadDto.codigoPais
        estado = registroCiudadDto.estado
        pais = registroCiudadDto.pais
    }
}