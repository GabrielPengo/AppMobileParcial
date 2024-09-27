package com.example.parcialapp

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcialapp.databinding.ActivityLoginBinding
import com.example.parcialapp.databinding.ActivityMylistBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    private val usuariosBD = UsuariosBD.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Restaure o estado, se houver
        if (savedInstanceState != null) {
            viewModel.email = savedInstanceState.getString("email") ?: ""
            viewModel.password = savedInstanceState.getString("password") ?: ""
        }

        // Preenche os campos com os dados do ViewModel
        binding.editTextEmail.setText(viewModel.email)
        binding.editTextPassword.setText(viewModel.password)

        binding.loginButton.setOnClickListener {
            // Salva os dados do usuário no ViewModel ao clicar no botão
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()

            if(email.isEmpty() || email.isBlank() || password.isEmpty() || password.isBlank()) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Aviso")
                builder.setMessage("Por favor, preencha todos os campos.")
                builder.setPositiveButton("OK") { dialog: DialogInterface, _: Int ->
                    dialog.dismiss()
                }

                val dialog = builder.create()
                dialog.show()
            }
            else {
                viewModel.email = email
                viewModel.password = password
                val usuario = usuariosBD.getUsuario(email, password)
                if(usuario != null) {
                    val intent = Intent(this, MyListActivity::class.java)
                    startActivity(intent)
                }
                else {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Aviso")
                    builder.setMessage("Por favor, verifique os dados inseridos ou cadastre-se.")
                    builder.setPositiveButton("OK") { dialog: DialogInterface, _: Int ->
                        dialog.dismiss()
                    }

                    val dialog = builder.create()
                    dialog.show()
                }
            }
        }

        binding.regButton.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Salva os dados do ViewModel no outState
        outState.putString("email", viewModel.email)
        outState.putString("password", viewModel.password)
    }

}

class LoginViewModel : ViewModel() {
    var email: String = ""
    var password: String = ""
}
