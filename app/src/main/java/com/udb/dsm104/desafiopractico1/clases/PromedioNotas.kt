package com.udb.dsm104.desafiopractico1.clases

import java.math.BigDecimal
import java.math.RoundingMode

class PromedioNotas(
    var nombre: String,
    private var nota1: BigDecimal,
    private var nota2: BigDecimal,
    private var nota3: BigDecimal,
    private var nota4: BigDecimal,
    private var nota5: BigDecimal
) {

    public fun CalcularPromedio(): BigDecimal {
        var resultado = BigDecimal(0)
        resultado += nota1
        resultado += nota2
        resultado += nota3
        resultado += nota4
        resultado += nota5

        resultado /= BigDecimal(5)

        return resultado
    }

    public fun MostrarAprobadoReprobado(): String {
        var resultado = CalcularPromedio()

        if(resultado >= BigDecimal(6) ){
            return "Aprobado"
        }else{
            return "Reprobado"
        }
    }
}