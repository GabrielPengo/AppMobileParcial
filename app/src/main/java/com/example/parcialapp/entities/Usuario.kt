package com.example.parcialapp.entities

class Usuario(private var nome: String, private var email: String, private var senha: String) {

    fun getNome(): String{
        return nome;
    }

    fun getEmail(): String{
        return email;
    }

    fun getSenha(): String {
        return senha;
    }

    fun setNome(nome: String) {
        this.nome = nome;
    }

    fun setEmail(email: String) {
        this.email = email;
    }

    fun setSenha(senha: String) {
        this.senha = senha;
    }
}