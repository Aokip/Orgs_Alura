package com.example.orgs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
        title = "Detalhes"
/*
utiliza o intent para recuperar o objt da classe main, coletando o objt e informando onde será apresentado,
utilizando o binding e determinando onde cada informação será alocada
 */
        RecebeDados()

    }
/*
Implementa o menu na actv e faz o processo de inflater para ser apresentado na actv de detalhes do cadastro

 */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detalhes, menu)
        return super.onCreateOptionsMenu(menu)
    }
/*
   função onOptionsItemSelected tem a função de identificar qual menu foi selecionado e realizar a
   ação pertinente do menu, no código abaixo o "when" é utilizado para realizar a ação de -> QUANDO o menu X
   for selecionado realizar a ação de editar, QUANDO o menu Y for selecionado realizar ação pertinente
 */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_editar -> {

            }
            R.id.menu_remover -> {

            }
        }
        return super.onOptionsItemSelected(item)
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