package com.udb.dsm104.desafiopractico1.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udb.dsm104.desafiopractico1.databinding.FragmentNotificationsBinding
import android.widget.Button
import android.widget.EditText
import com.udb.dsm104.desafiopractico1.Calculadora
import java.math.BigDecimal

class NotificationsFragment : Fragment() {

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



    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        txtUno = binding.TxtUno
        txtDos = binding.TxtDos
        btnSuma = binding.BtnSuma
        btnResta = binding.BtnResta
        btnMultiplicacion = binding.BtnMultiplicacion
        btnDivision = binding.BtnDivision
        txtMensaje  = binding.TxtResultado

        btnSuma.setOnClickListener { realizarOperacion(calculadora::sumar) }
        btnResta.setOnClickListener { realizarOperacion(calculadora::restar) }
        btnMultiplicacion.setOnClickListener { realizarOperacion(calculadora::multiplicar) }
        btnDivision.setOnClickListener { realizarOperacion(calculadora::dividir) }


        return root


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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