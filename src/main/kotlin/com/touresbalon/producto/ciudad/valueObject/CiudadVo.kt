package com.touresbalon.producto.ciudad.valueObject

class CiudadVo(var parm: String) {

    private lateinit var string: String

    val REPLACE = "Ciudad"
    var ERROR_CONTIENE_NUMERO = "El parametro $REPLACE contiene valores numericos"
    var ERROR_PARAMETRO_VACIO = "El parametro $REPLACE esta vacio"


    /**
     * Metodo que valida si el string contiene numeros
     */
    fun validaString(): Any =
            when {
                parm.isEmpty() -> ERROR_PARAMETRO_VACIO
                parm.matches(Regex(".*[0-9].*")) -> ERROR_CONTIENE_NUMERO
                else -> {
                    string = parm
                    true
                }
            }

    /**
     * metodo que retorna el parametro ajustado a minusculas
     */
    fun getToLowerCase() = string.toLowerCase()

    /**
     * Metodo que retorna el parametro ajustado a capitalCase
     */
    fun getToCapitalCase() = string.capitalize()

}