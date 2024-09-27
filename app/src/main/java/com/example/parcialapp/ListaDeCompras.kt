package com.example.parcialapp

class ListaDeCompras (private var nome: String, private var produtos: MutableList<Produto>){

    fun getNome(): String {
        return nome
    }

    fun getProdutos(): List<Produto> {
        return produtos;
    }
}