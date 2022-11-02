package com.lugares_j.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.lugares_j.databinding.LugarFilaBinding
import com.lugares_j.model.Lugar
import com.lugares_j.ui.lugar.LugarFragmentDirections

class LugarAdapter : RecyclerView.Adapter<LugarAdapter.LugarViewHolder>() {

    inner class LugarViewHolder(private val itemBinding: LugarFilaBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {


        fun dibuja(lugar: Lugar) {
            itemBinding.tvNombre.text = lugar.nombre
            itemBinding.tvCorreo.text = lugar.correo
            itemBinding.tvTelefono.text = lugar.telefono
            itemBinding.tvWeb.text = lugar.web
            itemBinding.vistaFila.setOnClickListener {
                val action = LugarFragmentDirections
                    .actionNavLugarToUpdateLugarFragment(lugar)
                itemView.findNavController().navigate(action)

            }
        }
    }

    private var listaLugares = emptyList<Lugar>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugarViewHolder {

        val itemBinding = LugarFilaBinding
            .inflate(
                LayoutInflater.from(parent.context),
        parent, false)

        return LugarViewHolder(itemBinding)

    }

    override fun onBindViewHolder(holder: LugarViewHolder, position: Int) {

        val lugar = listaLugares[position]
        holder.dibuja(lugar)

    }

    override fun getItemCount(): Int {

        return listaLugares.size

    }

    fun setListaLugares(lugares: List<Lugar>) {
        this.listaLugares = lugares
        notifyDataSetChanged()
    }


}