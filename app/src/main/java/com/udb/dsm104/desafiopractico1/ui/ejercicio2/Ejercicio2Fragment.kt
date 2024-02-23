package com.udb.dsm104.desafiopractico1.ui.ejercicio2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udb.dsm104.desafiopractico1.clases.PromedioNotas
import com.udb.dsm104.desafiopractico1.clases.Salario
import com.udb.dsm104.desafiopractico1.clases.Utils
import com.udb.dsm104.desafiopractico1.databinding.FragmentEjercicio2Binding

class Ejercicio2Fragment : Fragment() {

    private var _binding: FragmentEjercicio2Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var btnCalcular: Button
    private lateinit var txtMensaje: TextView

    private lateinit var txtSalario: EditText
    private lateinit var txtNombre: EditText
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val ejercicio2ViewModel =
            ViewModelProvider(this).get(Ejercicio2ViewModel::class.java)

        _binding = FragmentEjercicio2Binding.inflate(inflater, container, false)
        val root: View = binding.root

        btnCalcular = binding.BtnCalcular
        txtMensaje = binding.TxtResultado

        txtSalario = binding.TxtSalario
        txtNombre = binding.TxtNombre

        btnCalcular.setOnClickListener { realizarCalculoRenta() }

        return root
    }

    private fun realizarCalculoRenta() {
        val utils = Utils()
        val salario = Salario(
            txtNombre.text.toString(),
            utils.obtenerNumero(txtSalario),
        )

        var mensaje:String = "Estimado: " + salario.nombre
        mensaje += "\nSu Salario base es de: $" + salario.salarioBase
        mensaje += "\nSe le aplica un descuento de AFP de: $" + salario.CalcularAFP()
        mensaje += "\nSe le aplica un descuento de ISSS de: $" + salario.CalcularISSS()
        mensaje += "\nSe le aplica un descuento de Renta de: $" + salario.CalcularRenta()
        mensaje += "\nSu Salario Total es de: $" + salario.ObtenerSalarioTotal()
        txtMensaje.text = mensaje
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}