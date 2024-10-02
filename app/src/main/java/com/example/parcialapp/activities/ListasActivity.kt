package com.example.parcialapp.activities

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
import com.example.parcialapp.R
import com.example.parcialapp.databinding.ActivityListasBinding
import com.example.parcialapp.db.ListaBD
import com.example.parcialapp.entities.Lista

class ListasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListasBinding
    private val viewModel: MyListViewModel by viewModels()
    private lateinit var adapter: ListaAdapterActivity
    private val listaBD = ListaBD.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityListasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityListasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listasList = listaBD.getListas()

        adapter = ListaAdapterActivity(listasList, ::onListItemClicked)
        val layoutManager = LinearLayoutManager(this)

        binding.recyclerViewListasDeCompras.adapter = adapter
        binding.recyclerViewListasDeCompras.layoutManager = layoutManager

        binding.botaoFlutuante.setOnClickListener {
            val intent = Intent(this, AdListaActivity::class.java)
            startActivity(intent)
        }
    }

    private fun onListItemClicked(lista: Lista) {
        val intent = Intent(this, AdProdutoActivity::class.java)
        startActivity(intent)
    }

    public override fun onResume() {
        super.onResume()
        atualizaTela()
    }

    private fun atualizaTela() {
        val listasList = listaBD.getListas()
        adapter.updateList(listasList)
    }
}

class MyListViewModel : ViewModel() {
//    var email: String = ""
//    var password: String = ""
}
