package com.example.parcialapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcialapp.R
import com.example.parcialapp.databinding.ActivityListasBinding
import com.example.parcialapp.db.ListasBD
import com.example.parcialapp.entities.ListaDeCompras
import com.example.parcialapp.entities.Usuario
import java.io.Serializable

class ListasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListasBinding
    private lateinit var adapter: ListaAdapterActivity
    private val listaBD = ListasBD.instance
    private lateinit var usuario: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityListasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        usuario = intent.getSerializableExtra("usuarioLogado") as Usuario
        val listasList = listaBD.getListas(usuario)

        adapter = ListaAdapterActivity(listasList, ::onListItemClicked)
        val layoutManager = LinearLayoutManager(this)

        binding.recyclerViewListasDeCompras.adapter = adapter
        binding.recyclerViewListasDeCompras.layoutManager = layoutManager

        binding.botaoFlutuante.setOnClickListener {
            val intent = Intent(this, AdListaActivity::class.java)
            intent.putExtra("usuarioLogado", usuario as Serializable)
            startActivity(intent)
        }
    }

    private fun onListItemClicked(listaDeCompras: ListaDeCompras) {
        val intent = Intent(this, ProdutosActivity::class.java)
        intent.putExtra("listaDeCompras", listaDeCompras as Serializable)
        startActivity(intent)
    }

    public override fun onResume() {
        super.onResume()
        atualizaTela()
    }

    private fun atualizaTela() {
        val listasList = listaBD.getListas(usuario)
        adapter.updateList(listasList)
    }
}
