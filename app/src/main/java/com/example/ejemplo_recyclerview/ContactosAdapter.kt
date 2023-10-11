package com.example.ejemplo_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemplo_recyclerview.databinding.ItemContactoBinding

class ContactosAdapter (
    private  val contactos: List<Contacto>,
    private val contactoPulsadoListener: ContactoPulsadoListener

    ): RecyclerView.Adapter<ContactosAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemContactoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(contacto: Contacto) {

            binding.nombre.text=contacto.nombre

            binding.tlf.text=contacto.tlf

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemContactoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contactos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, posicion: Int) {
        holder.bind(contactos[posicion])

        holder.itemView.setOnClickListener{
            contactoPulsadoListener.contactoPulsado(contactos[posicion])
        }
    }
}
