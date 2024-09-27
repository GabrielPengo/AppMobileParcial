package com.example.parcialapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialapp.databinding.ActivityListadecomprasBinding

class ListaDeComprasAdapter(
    private val listasDeCompras: List<ListaDeCompras>,
    private val onClick: (ListaDeCompras) -> Unit) : RecyclerView.Adapter<ListaDeComprasAdapter.ViewHolder>() {

    inner class ViewHolder(
        private val binding: ActivityListadecomprasBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private var currentItem: ListaDeCompras? = null

        init {
            itemView.setOnClickListener {
                currentItem?.let {
                    onClick(it)
                }
            }
        }

        fun bind(lista: ListaDeCompras) {
            currentItem = lista

            binding.nomeLista.text = lista.getNome()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ActivityListadecomprasBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listasDeCompras[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = listasDeCompras.size
}