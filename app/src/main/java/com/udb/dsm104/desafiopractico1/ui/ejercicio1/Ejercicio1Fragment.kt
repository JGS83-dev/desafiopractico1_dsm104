package com.udb.dsm104.desafiopractico1.ui.ejercicio1

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
import com.udb.dsm104.desafiopractico1.clases.Utils
import com.udb.dsm104.desafiopractico1.databinding.FragmentEjercicio1Binding
import java.math.BigDecimal

class Ejercicio1Fragment : Fragment() {

    private var _binding: FragmentEjercicio1Binding? = null

    private lateinit var btnCalcular: Button
    private lateinit var txtMensaje: TextView

    private lateinit var txtNota1:EditText
    private lateinit var txtNota2:EditText
    private lateinit var txtNota3:EditText
    private lateinit var txtNota4:EditText
    private lateinit var txtNota5:EditText
    private lateinit var txtNombre:EditText
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

        btnCalcular = binding.BtnCalcular
        txtMensaje = binding.TxtResultado

        txtNota1 = binding.TxtNota1
        txtNota2 = binding.TxtNota2
        txtNota3 = binding.TxtNota3
        txtNota4 = binding.TxtNota4
        txtNota5 = binding.TxtNota5

        txtNombre = binding.TxtNombre
        btnCalcular.setOnClickListener { realizarCalculo() }

        return root
    }

    private fun realizarCalculo() {
        val utils = Utils()
        val promedioNotas = PromedioNotas(
            txtNombre.text.toString(),
            utils.obtenerNumero(txtNota1),
            utils.obtenerNumero(txtNota2),
            utils.obtenerNumero(txtNota3),
            utils.obtenerNumero(txtNota4),
            utils.obtenerNumero(txtNota5)
        )

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