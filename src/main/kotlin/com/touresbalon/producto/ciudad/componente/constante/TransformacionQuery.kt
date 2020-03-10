package com.touresbalon.producto.ciudad.componente.constante

import java.lang.StringBuilder

class TransformacionQuery {

    companion object{
        val LIKE = "%"

        /**
         * Metodo estatico que recibe una abreviatura o un string y le agrega los '%'
         * para construir una condicion de busqueda LIKE sobre un Query de Repository
         */
        fun crearCondicionQueryLikeDesde(abreviatura: String) =
             StringBuilder(LIKE)
                    .append(abreviatura.toLowerCase())
                    .append(LIKE).toString()

    }
}