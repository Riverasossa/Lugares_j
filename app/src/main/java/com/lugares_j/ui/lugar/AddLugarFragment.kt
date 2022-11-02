package com.lugares_j.ui.lugar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.lugares_j.R
import com.lugares_j.databinding.FragmentAddLugarBinding
import com.lugares_j.model.Lugar
import com.lugares_j.viewmodel.LugarViewModel


class AddLugarFragment : Fragment() {


    private lateinit var lugarViewModel: LugarViewModel
    private var _binding: FragmentAddLugarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lugarViewModel =
            ViewModelProvider(this).get(LugarViewModel::class.java)

        _binding = FragmentAddLugarBinding.inflate(inflater, container, false)

        binding.btAdd.setOnClickListener{ addLugar() }

        return binding.root
    }

    private fun addLugar() {
        val nombre = binding.etNombre.text.toString()

        if(nombre.isNotEmpty()) {
            val correo = binding.etCorreo.text.toString()
            val telefono = binding.etTelefono.text.toString()
            val web = binding.etWeb.text.toString()
            val lugar = Lugar(0, nombre, correo, telefono, web, 0.0,0.0,0.0, "", "")

            lugarViewModel.saveLugar(lugar)
            Toast.makeText(requireContext(),
            getString(R.string.msg_lugar_added),
            Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addLugarFragment_to_nav_lugar2)

        }else {
            Toast.makeText(requireContext(),
            getString(R.string.msg_data),
            Toast.LENGTH_SHORT).show()

        }





    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}