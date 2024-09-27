package com.example.parcialapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcialapp.databinding.ActivityLoginBinding
import com.example.parcialapp.databinding.ActivityMylistBinding

class MyListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMylistBinding
    private val viewModel: MyListViewModel by viewModels()
    //private val usuariosBD = UsuariosBD.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMylistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityMylistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listasList = listOf(
            ListaDeCompras("lista1"),
            ListaDeCompras("lista2"),
            ListaDeCompras("lista3"),
            ListaDeCompras("lista4"),
            ListaDeCompras("lista5"),
            ListaDeCompras("lista6"),
            ListaDeCompras("lista7"),
            ListaDeCompras("lista8"),
            ListaDeCompras("lista9"),
            ListaDeCompras("lista10"),
            ListaDeCompras("lista11"),
            ListaDeCompras("lista12"),
            ListaDeCompras("lista13"),
            ListaDeCompras("lista14"),
            ListaDeCompras("lista15"),
            ListaDeCompras("lista16"),
            ListaDeCompras("lista17")
        )

        val adapter = ListaDeComprasAdapter(listasList, ::onListItemClicked)
        val layoutManager = LinearLayoutManager(this)

        binding.recyclerViewListasDeCompras.adapter = adapter
        binding.recyclerViewListasDeCompras.layoutManager = layoutManager

    }

    private fun onListItemClicked(lista: ListaDeCompras) {
        Toast.makeText(this, "Clicou!", Toast.LENGTH_LONG).show()
    }
}

class MyListViewModel : ViewModel() {
//    var email: String = ""
//    var password: String = ""
}
