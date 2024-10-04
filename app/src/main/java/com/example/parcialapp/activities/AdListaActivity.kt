package com.example.parcialapp.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.parcialapp.databinding.ActivityAdlistaBinding
import com.example.parcialapp.db.ListaBD
import com.example.parcialapp.entities.Lista

class AdListaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdlistaBinding
    val listaBD = ListaBD.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityAdlistaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button5.setOnClickListener {
            val nome = binding.editText6.text.toString()
            val lista = Lista(nome)
            listaBD.adLista(lista)
            finish()
        }
    }
}