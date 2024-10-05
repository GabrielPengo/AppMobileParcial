package com.example.parcialapp.activities

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.example.parcialapp.R
import com.example.parcialapp.databinding.ActivityLoginBinding
import com.example.parcialapp.db.UsuariosBD
import com.bumptech.glide.Glide

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val usuariosBD = UsuariosBD.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val imageView: ImageView = findViewById(R.id.imageView4)
        Glide.with(this).load("https://i0.wp.com/www.opuspesquisa.com/wp-content/uploads/2021/03/Pesquisa-de-mercado-para-supermercado.png?resize=730%2C441&ssl=1").into(imageView)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Glide.with(this)
            .load("https://i0.wp.com/www.opuspesquisa.com/wp-content/uploads/2021/03/Pesquisa-de-mercado-para-supermercado.png?resize=730%2C441&ssl=1")
            .into(binding.imageView4) // Use o ImageView do binding

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
                val usuario = usuariosBD.getUsuario(email, password)
                if(usuario != null) {
                    val intent = Intent(this, ListasActivity::class.java)
                    intent.putExtra("usuarioLogado", usuario)
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
}
