package com.touresbalon.producto.ciudad.servicio

import com.touresbalon.producto.ciudad.dto.CiudadDto
import com.touresbalon.producto.ciudad.dto.GetCiudadDto
import com.touresbalon.producto.ciudad.entidad.Ciudad

interface ServicioCiudad {

    /**
     * Metodo para registrar una ciudad desde un dto o valueObject
     */
    fun registrarCiudadDesde(ciudadDto: CiudadDto)

    /**
     * Metodo que obtiene una lista de posibles opciones de ciudad de acuerdo al filtro de abreviatura
     */
    fun encontrarCiudadQueContiene(abreviaturaCiudad: String): MutableList<GetCiudadDto>

}