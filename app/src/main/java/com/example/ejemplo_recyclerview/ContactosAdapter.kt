package com.example.ejemplo_recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
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

            //en caso de que el contacto sea mujer ponemos visible el icono
            if (contacto.gender=="mujer") {
                binding.fotoContacto.setImageResource(R.drawable.mujer)
            } else {
                binding.fotoContacto.setImageResource(R.drawable.hombre)
            }

            binding.inicial.text=contacto.nombre.get(0).toString()

            val inicial= binding.inicial.text
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

        var inical =contactos[posicion].nombre.get(0).toString()

        holder.binding.inicial.text=inical

        holder.binding.fotoContacto.setOnClickListener {
            if (holder.binding.inicial.isVisible) {
                holder.binding.inicial.visibility = View.INVISIBLE

                holder.binding.nombre.visibility=View.VISIBLE
                holder.binding.tlf.visibility=View.VISIBLE

            } else {

                holder.binding.inicial.visibility = View.VISIBLE
                holder.binding.nombre.visibility=View.INVISIBLE
                holder.binding.tlf.visibility=View.INVISIBLE

            }
        }

        holder.itemView.setOnClickListener{
            contactoPulsadoListener.contactoPulsado(contactos[posicion])
        }
    }
}
