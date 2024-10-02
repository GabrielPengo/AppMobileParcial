package com.example.parcialapp.activities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialapp.databinding.ActivityListaadapterBinding
import com.example.parcialapp.entities.Lista

class ListaAdapterActivity(
    private var listasDeCompras: List<Lista>,
    private val onClick: (Lista) -> Unit) : RecyclerView.Adapter<ListaAdapterActivity.ViewHolder>() {

    inner class ViewHolder(
        private val binding: ActivityListaadapterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private var currentItem: Lista? = null

        init {
            itemView.setOnClickListener {
                currentItem?.let {
                    onClick(it)
                }
            }
        }

        fun bind(lista: Lista) {
            currentItem = lista
            binding.nomeLista.text = lista.getNome()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ActivityListaadapterBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listasDeCompras[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = listasDeCompras.size

    fun updateList(novaLista: List<Lista>) {
        listasDeCompras = novaLista
        notifyDataSetChanged()
    }
}