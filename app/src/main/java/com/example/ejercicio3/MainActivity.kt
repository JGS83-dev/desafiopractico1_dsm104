package com.example.ejercicio3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    private lateinit var txtUno: EditText
    private lateinit var txtDos: EditText
    private lateinit var btnSuma: Button
    private lateinit var btnResta: Button
    private lateinit var btnMultiplicacion: Button
    private lateinit var btnDivision: Button
    private lateinit var txtMensaje: TextView

    //Llamamos a la clase
    private val calculadora = Calculadora()
    //Fin del llamado de clase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtUno = findViewById(R.id.TxtUno)
        txtDos = findViewById(R.id.TxtDos)
        btnSuma = findViewById(R.id.BtnSuma)
        btnResta = findViewById(R.id.BtnResta)
        btnMultiplicacion = findViewById(R.id.BtnMultiplicacion)
        btnDivision = findViewById(R.id.BtnDivision)
        txtMensaje  = findViewById(R.id.TxtResultado)

        btnSuma.setOnClickListener { realizarOperacion(calculadora::sumar) }
        btnResta.setOnClickListener { realizarOperacion(calculadora::restar) }
        btnMultiplicacion.setOnClickListener { realizarOperacion(calculadora::multiplicar) }
        btnDivision.setOnClickListener { realizarOperacion(calculadora::dividir) }

    }

    private fun realizarOperacion(operacion: (BigDecimal, BigDecimal) -> BigDecimal) {
        val numero1 = obtenerNumero(txtUno)
        val numero2 = obtenerNumero(txtDos)

        if (numero1 != null && numero2 != null) {
            try {
                val resultado = operacion(numero1, numero2)
                // Mostrar el resultado con dos decimales
                mostrarResultado(resultado)
            } catch (ex: ArithmeticException) {
                // Manejar división por cero u otros errores
                mostrarMensaje("Error: ${ex.message}")
            }
        } else {
            mostrarMensaje("Por favor ingrese números válidos")
        }
    }


    private fun obtenerNumero(txtNumero: EditText): BigDecimal? {
        val texto = txtNumero.text.toString()
        // Validar que el texto sea un número decimal válido
        return try {
            BigDecimal(texto)
        } catch (ex: NumberFormatException) {
            null
        }
    }


    private fun mostrarResultado(resultado: BigDecimal) {
        //Mostrar el resultado con dos decimales
        txtDos.setText("")
        txtUno.setText("")
        txtMensaje.setText(resultado.setScale(2, BigDecimal.ROUND_HALF_UP).toString())
    }


    private fun mostrarMensaje(mensaje: String) {
        //Seteo los EditText en blanco para que realice otra operacion
        //El manejo del error o el resultado me lo mostrara en txtMensaje
        txtUno.setText("")
        txtDos.setText("")
        txtMensaje.text = mensaje
    }
}