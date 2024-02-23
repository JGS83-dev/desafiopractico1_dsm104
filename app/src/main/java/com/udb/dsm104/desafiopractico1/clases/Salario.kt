package com.udb.dsm104.desafiopractico1.clases

import java.math.BigDecimal
import java.math.RoundingMode

class Salario(
    val nombre: String,
    val salarioBase: BigDecimal
) {
    val afp = BigDecimal(0.04)
    val isss = BigDecimal(0.03)
    var salarioDespuesDescuentos: BigDecimal = salarioBase
    var salarioTotal = BigDecimal(0)
    var renta = BigDecimal(0.05)
    public fun ObtenerSalarioTotal(): BigDecimal {
        return salarioTotal
    }

    public fun CalcularAFP():BigDecimal{
        val retencionAfp = BigDecimal((salarioBase * afp).toString()).setScale(2, RoundingMode.HALF_EVEN);
        salarioDespuesDescuentos -= retencionAfp
        return retencionAfp
    }

    public fun CalcularISSS():BigDecimal{
        val retencionSeguro = BigDecimal((salarioBase * isss).toString()).setScale(2, RoundingMode.HALF_EVEN);
        salarioDespuesDescuentos -= retencionSeguro
        return retencionSeguro
    }

    public fun CalcularRenta():BigDecimal{
//        println("Salario despues de descuentos -> " + salarioDespuesDescuentos)
//        if(salarioDespuesDescuentos >= BigDecimal(472.01) && salarioDespuesDescuentos <= BigDecimal(895.24)){
//            renta = BigDecimal(0.1)
//        }else if(salarioDespuesDescuentos >= BigDecimal(895.25) && salarioDespuesDescuentos <= BigDecimal(2038.1)){
//            renta = BigDecimal(0.2)
//        }else if(salarioDespuesDescuentos >= BigDecimal(2038.11)){
//            renta = BigDecimal(0.3)
//        }else{
//            renta = BigDecimal(0)
//        }
        val retencionRenta = BigDecimal((salarioDespuesDescuentos * renta).toString()).setScale(2, RoundingMode.HALF_EVEN);
        salarioTotal = salarioDespuesDescuentos - retencionRenta
        return retencionRenta
    }
}