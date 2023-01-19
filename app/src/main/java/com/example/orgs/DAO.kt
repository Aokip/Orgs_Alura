package com.example.orgs

import com.example.orgs.adapter.lista.Cadastro

class DAO {
    private val listadeCadastro = mutableListOf<Cadastro>()
    fun adicionar (cadastro : Cadastro){
        listadeCadastro.add(cadastro)

    }
    fun bucatodos () : List<Cadastro>{
      return listadeCadastro.toList()
    }
}