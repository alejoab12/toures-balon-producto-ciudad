package com.touresbalon.producto.ciudad.entidad

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed

class Ciudad {
    @Id
    lateinit var id: ObjectId
    @Indexed
    lateinit var ciudad: String
    lateinit var codigoCiudad: String
    lateinit var codigoPais: String
    lateinit var estado: String
    lateinit var pais: String
}