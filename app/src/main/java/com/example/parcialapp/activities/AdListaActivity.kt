package com.example.parcialapp.activities

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.parcialapp.R
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

        val imagemSelecionada: ImageView = findViewById(R.id.floatingActionButton2)

        binding.floatingActionButton2.setOnClickListener {
            selectImage()
        }

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


    private fun selectImage() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivity(intent)
    }
}