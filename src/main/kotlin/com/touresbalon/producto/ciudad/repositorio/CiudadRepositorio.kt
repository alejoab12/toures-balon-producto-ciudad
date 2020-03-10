package com.touresbalon.producto.ciudad.repositorio

import com.touresbalon.producto.ciudad.entidad.Ciudad
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CiudadRepositorio: MongoRepository<Ciudad, String> {

    @Query("{ciudad:{\$regex: ?0}}")
    fun findCiudadByCiudadRegex(regexp: String): MutableList<Ciudad>

}