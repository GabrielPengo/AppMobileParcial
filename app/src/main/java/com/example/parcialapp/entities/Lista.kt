package com.example.parcialapp.entities

class Lista (private var nome: String) {

    private var produtos: MutableList<Produto> = mutableListOf()

    fun getNome(): String {
        return nome
    }

    fun getListaProdutos(): MutableList<Produto> {
        return produtos;
    }
}