package com.example.parcialapp

class Produto(private var nome: String, private var quantidade: Int, private var unidade: String, private var categoria: String,
              private var comprado: Boolean) {

    fun getNome(): String {
        return nome;
    }

    fun getQuantidadeUnidade(): String {
        return "$quantidade $unidade"
    }

    fun getCategoria(): String {
        return categoria
    }

    fun setComprado(comprado: Boolean) {
        this.comprado = comprado
    }
}
