package com.example.parcialapp

enum class EnumUnidade(var descricao: String) {
    UN("unidade(s)"),
    PCT("pacote(s)"),
    KG("kg"),
    CX("caixa(s)");

    fun getDescricao(): String {
        return descricao
    }
}
