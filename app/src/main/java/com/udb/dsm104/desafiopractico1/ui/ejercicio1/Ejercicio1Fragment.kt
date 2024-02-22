package com.udb.dsm104.desafiopractico1.ui.ejercicio1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udb.dsm104.desafiopractico1.databinding.FragmentEjercicio1Binding

class Ejercicio1Fragment : Fragment() {

    private var _binding: FragmentEjercicio1Binding? = null

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

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}