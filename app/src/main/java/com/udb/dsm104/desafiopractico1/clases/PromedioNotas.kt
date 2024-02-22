package com.udb.dsm104.desafiopractico1.clases

import java.math.BigDecimal
import java.math.RoundingMode

class PromedioNotas(
    val nombre: String,
    val nota1: BigDecimal,
    val nota2: BigDecimal,
    val nota3: BigDecimal,
    val nota4: BigDecimal,
    val nota5: BigDecimal
) {

    public fun CalcularPromedio(): BigDecimal? {
        val resultado: BigDecimal = BigDecimal(0)
        resultado.add(nota1)
        resultado.add(nota2)
        resultado.add(nota3)
        resultado.add(nota4)
        resultado.add(nota5)
        return resultado.divide(BigDecimal(5), 2, RoundingMode.HALF_UP)
    }

    public fun MostrarAprobadoReprobado(): String? {
        val resultado: BigDecimal = BigDecimal(0)
        resultado.add(nota1)
        resultado.add(nota2)
        resultado.add(nota3)
        resultado.add(nota4)
        resultado.add(nota5)
        resultado.divide(BigDecimal(5), 2, RoundingMode.HALF_UP)

        if(resultado >= BigDecimal(6) ){
            return "Aprobado"
        }else{
            return "Reprobado"
        }
    }
}