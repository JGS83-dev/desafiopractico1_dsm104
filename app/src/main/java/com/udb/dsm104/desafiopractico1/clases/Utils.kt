package com.udb.dsm104.desafiopractico1.clases

import android.widget.EditText
import java.math.BigDecimal

class Utils {
    public fun obtenerNumero(txtNumero: EditText): BigDecimal {
        val texto = txtNumero.text.toString()
        // Validar que el texto sea un número decimal válido
        return try {
            BigDecimal(texto)
        } catch (ex: NumberFormatException) {
            BigDecimal(0)
        }
    }
}