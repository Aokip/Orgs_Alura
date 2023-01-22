package com.example.orgs

import com.example.orgs.adapter.lista.Cadastro

class DAO {
    fun adicionar (cadastro : Cadastro){
        listadeCadastro.add(cadastro)

    }


        fun buscatodos() : List<Cadastro>{
          return listadeCadastro.toList()

    }

    companion object {
        private val listadeCadastro = mutableListOf<Cadastro>()
    }
}