package com.udb.dsm104.desafiopractico1.ui.ejercicio1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udb.dsm104.desafiopractico1.clases.PromedioNotas
import com.udb.dsm104.desafiopractico1.clases.Utils
import com.udb.dsm104.desafiopractico1.databinding.FragmentEjercicio1Binding
import java.math.BigDecimal

class Ejercicio1Fragment : Fragment() {

    private var _binding: FragmentEjercicio1Binding? = null

    private lateinit var btnCalcular: Button
    private lateinit var txtMensaje: TextView

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val ejercicio1ViewModel =
            ViewModelProvider(this).get(Ejercicio1ViewModel::class.java)

        _binding = FragmentEjercicio1Binding.inflate(inflater, container, false)
        val root: View = binding.root

        val utils = Utils()

        val promedioNotas = PromedioNotas(binding.TxtNombre.text.toString(),
            utils.obtenerNumero(binding.TxtNota1),
            utils.obtenerNumero(binding.TxtNota2),
            utils.obtenerNumero(binding.TxtNota3),
            utils.obtenerNumero(binding.TxtNota4),
            utils.obtenerNumero(binding.TxtNota5))

        btnCalcular = binding.BtnCalcular
        txtMensaje = binding.TxtResultado
        btnCalcular.setOnClickListener { realizarCalculo(promedioNotas) }

        return root
    }

    private fun realizarCalculo(promedioNotas: PromedioNotas) {
       var mensaje:String = "Estimado: " + promedioNotas.nombre
       mensaje += "\nSu promedio es de: " + promedioNotas.CalcularPromedio().toString()
       mensaje += "\nUsted ha: " + promedioNotas.MostrarAprobadoReprobado().toString()
        txtMensaje.text = mensaje
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}