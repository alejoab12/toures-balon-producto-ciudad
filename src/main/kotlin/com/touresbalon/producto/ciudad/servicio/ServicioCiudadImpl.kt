package com.touresbalon.producto.ciudad.servicio

import com.touresbalon.producto.ciudad.componente.constante.TransformacionQuery
import com.touresbalon.producto.ciudad.dto.CiudadDto
import com.touresbalon.producto.ciudad.dto.GetCiudadDto
import com.touresbalon.producto.ciudad.entidad.Ciudad
import com.touresbalon.producto.ciudad.repositorio.CiudadRepositorio
import com.touresbalon.producto.ciudad.valueObject.CiudadVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ServicioCiudadImpl : ServicioCiudad {

    @Autowired
    lateinit var ciudadRepository: CiudadRepositorio

    /**
     * Metodo para registrar una ciudad desde un dto o valueObject
     */
    override fun registrarCiudadDesde(ciudadDto: CiudadDto) {
        var ciudad = Ciudad()
        ciudad.ciudad = ciudadDto.ciudad.getToLowerCase()
        ciudad.codigoCiudad = ciudadDto.codigoCiudad
        ciudad.codigoPais = ciudadDto.codigoPais
        ciudad.estado = ciudadDto.estado
        ciudad.pais = ciudadDto.pais
        ciudadRepository.insert(ciudad)
    }

    /**
     * Metodo que obtiene una lista de posibles opciones de ciudad de acuerdo al filtro de abreviatura
     */
    override fun encontrarCiudadQueContiene(abreviaturaCiudad: String): MutableList<GetCiudadDto> {
        var result = ciudadRepository.findCiudadByCiudadRegex(abreviaturaCiudad)
        var listaGetCiudadDto = mutableListOf<GetCiudadDto>()
        if (result.firstOrNull() is Ciudad) result.forEach {
            var getCiudadDto = GetCiudadDto()
            var ciudad = CiudadVo(it.ciudad)
            ciudad.validaString()
            getCiudadDto.ciudad = ciudad.getToCapitalCase()
            getCiudadDto.codigoCiudad = it.codigoCiudad
            getCiudadDto.codigoPais = it.codigoPais
            getCiudadDto.pais = it.pais
            getCiudadDto.id = it.id.toHexString()
            listaGetCiudadDto.add(getCiudadDto)
        }
        return listaGetCiudadDto
    }

    /**
     * Metodo que obtiene todas als ciudades registradas
     */
    override fun obtenerCiudades(): MutableList<GetCiudadDto>{
        var result = ciudadRepository.findAll()
        var listGetCiudadDto = mutableListOf<GetCiudadDto>()
        result.forEach {
            var getCiudadDto = GetCiudadDto()
            var ciudad = CiudadVo(it.ciudad)
            ciudad.validaString()
            getCiudadDto.ciudad = ciudad.getToCapitalCase()
            getCiudadDto.codigoCiudad = it.codigoCiudad
            getCiudadDto.codigoPais = it.codigoPais
            getCiudadDto.pais = it.pais
            getCiudadDto.id = it.id.toHexString()
            listGetCiudadDto.add(getCiudadDto)
        }
        return  listGetCiudadDto
    }
}