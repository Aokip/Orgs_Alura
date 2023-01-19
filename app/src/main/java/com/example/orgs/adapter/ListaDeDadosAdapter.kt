package com.example.orgs.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.adapter.lista.Cadastro

class ListaDeDadosAdapter(
    private val itens: List<Cadastro>
) : RecyclerView.Adapter<ListaDeDadosAdapter.ViewHolder>() {
    class ViewHolder(Listview: View) : RecyclerView.ViewHolder(Listview) {
        fun bindview(posicaoLista: Cadastro) {
            /* Ligação entre a lista "Cadastro" com os edt do "layout_dados" */
            val nome = itemView.findViewById<TextView>(R.id.edt_nome)
            val email = itemView.findViewById<TextView>(R.id.edt_email)
            val phone = itemView.findViewById<TextView>(R.id.edt_phone)

            nome.text = posicaoLista.nome
            email.text = posicaoLista.email
            phone.text = posicaoLista.phone.toString()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_dados, parent, false)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val posicaoLista = itens[position]
        holder.bindview(posicaoLista)

    }

    override fun getItemCount() = itens.size

}
