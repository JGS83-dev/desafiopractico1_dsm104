package com.udb.dsm104.desafiopractico1.clases

import java.math.BigDecimal
import java.math.RoundingMode


class Calculadora {

    fun sumar(numero1: BigDecimal, numero2: BigDecimal): BigDecimal {
        return numero1.add(numero2)
    }

    fun restar(numero1: BigDecimal, numero2: BigDecimal): BigDecimal {
        return numero1.subtract(numero2)
    }

    fun multiplicar(numero1: BigDecimal, numero2: BigDecimal): BigDecimal {
        return numero1.multiply(numero2)
    }

    fun dividir(numero1: BigDecimal, numero2: BigDecimal): BigDecimal {
        // Validación para evitar división por cero
        if (numero2.compareTo(BigDecimal.ZERO) == 0) {
            throw ArithmeticException("No se puede dividir por cero")
        }
        return numero1.divide(numero2, 2, RoundingMode.HALF_UP)
    }

}