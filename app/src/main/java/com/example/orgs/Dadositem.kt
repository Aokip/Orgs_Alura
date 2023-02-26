package com.example.orgs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.orgs.adapter.lista.Cadastro
import com.example.orgs.databinding.ActivityDadosItemBinding
import com.example.orgs.extenx.TentacarregarImagem

class Dadositem : AppCompatActivity() {
    private val binding by lazy {
        ActivityDadosItemBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
/*
utiliza o intent para recuperar o objt da classe main, coletando o objt e informando onde será apresentado,
utilizando o binding e determinando onde cada informação será alocada
 */
        RecebeDados()

    }

    private fun RecebeDados() {
        intent.getParcelableExtra<Cadastro>("CHAVEDOPRODUTO")?.let { produtocarregado ->
            binding.imgDadosItem.TentacarregarImagem(produtocarregado.imagem)
            binding.TVDadosItem.text = produtocarregado.email
            binding.TVDadosItem2.text = produtocarregado.phone.toString()
            binding.btDadosItem.text = produtocarregado.nome


        }
    }
}