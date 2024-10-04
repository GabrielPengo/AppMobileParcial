package com.example.parcialapp.db

import com.example.parcialapp.entities.Lista

class ListaBD {

    companion object {
        var instance: ListaBD = ListaBD()
    }

    private var listaListasDeCompras: MutableList<Lista> = mutableListOf()

    fun getListas(): List<Lista> {
        return listaListasDeCompras
    }

    fun adLista(lista: Lista) {
        listaListasDeCompras.add(lista)
    }
}