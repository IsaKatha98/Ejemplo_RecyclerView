package com.example.ejemplo_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.ejemplo_recyclerview.databinding.ContactosBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val contactos= ContactosBinding.inflate(layoutInflater)

        setContentView(contactos.root)

        contactos.vistaContactos.adapter=ContactosAdapter(

            listOf(

                Contacto("Juan","12345"),
                Contacto("María", "6784561523"),
                Contacto("Raúl","644789456"),
                Contacto("Ana","693882147"),

                Contacto("Juan","12345"),
                Contacto("María", "6784561523"),
                Contacto("Raúl","644789456"),
                Contacto("Ana","693882147"),

                Contacto("Juan","12345"),
                Contacto("María", "6784561523"),
                Contacto("Raúl","644789456"),
                Contacto("Ana","693882147"),

                Contacto("Juan","12345"),
                Contacto("María", "6784561523"),
                Contacto("Raúl","644789456"),
                Contacto("Ana","693882147")
            )
        )
    }
}