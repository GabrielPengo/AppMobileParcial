package com.example.parcialapp.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.parcialapp.databinding.ActivityAdlistaBinding
import com.example.parcialapp.db.ListasBD
import com.example.parcialapp.entities.ListaDeCompras
import com.example.parcialapp.entities.Usuario

class AdListaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdlistaBinding
    private val listaBD = ListasBD.instance
    private lateinit var usuario: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        usuario = intent.getSerializableExtra("usuarioLogado") as Usuario

        binding = ActivityAdlistaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button5.setOnClickListener {
            val nome = binding.editText6.text.toString()
            val listaDeCompras = ListaDeCompras(nome, usuario)
            listaBD.adLista(listaDeCompras)
            finish()
        }
    }
}