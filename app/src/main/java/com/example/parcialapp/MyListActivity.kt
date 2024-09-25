package com.example.parcialapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
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

//        // Restaure o estado, se houver
//        if (savedInstanceState != null) {
//            viewModel.email = savedInstanceState.getString("email") ?: ""
//            viewModel.password = savedInstanceState.getString("password") ?: ""
//        }
//
//        // Preenche os campos com os dados do ViewModel
//        binding.editTextEmail.setText(viewModel.email)
//        binding.editTextPassword.setText(viewModel.password)
//
//        binding.loginButton.setOnClickListener {
//            // Salva os dados do usuário no ViewModel ao clicar no botão
//            val email = binding.editTextEmail.text.toString()
//            val password = binding.editTextPassword.text.toString()
//            viewModel.email = email
//            viewModel.password = password
//            val usuario = usuariosBD.getUsuario(email, password)
//            if(usuario != null) {
//                val intent = Intent(this, MyListActivity::class.java)
//                startActivity(intent) // Iniciar a nova atividade
//            }
//        }
//
//        binding.regButton.setOnClickListener {
//            val intent = Intent(this, CadastroActivity::class.java)
//            startActivity(intent) // Iniciar a nova atividade
//        }
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        // Salva os dados do ViewModel no outState
//        outState.putString("email", viewModel.email)
//        outState.putString("password", viewModel.password)
//    }
}

class MyListViewModel : ViewModel() {
    var email: String = ""
    var password: String = ""
}
