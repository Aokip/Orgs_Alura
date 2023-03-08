package com.example.orgs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.orgs.adapter.lista.Cadastro
import com.example.orgs.database.ProdutoDaoRom.Builder.CadastroBuilder
import com.example.orgs.databinding.ActivityDadosItemBinding
import com.example.orgs.extenx.TentacarregarImagem

class Dadositem : AppCompatActivity() {
    private lateinit var produto: Cadastro
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
        when (item.itemId) {
                R.id.menu_remover -> {
                    /*
                    - if (::produto.isInitialized) -> verifica se o produto foi inicializado para não enviar
                    um valor nulo ao abrir os dados do item e crashar o app, com a verificação "initialized"
                    verifica se ao clicar no produto foi recebido um obj do tipo cadastro, com a recebimento
                    do obj o produto foi inicializado.
                     */
                    if (::produto.isInitialized) {
                        val buider = CadastroBuilder().buider(this)
                        buider.deleta(produto)

                    }
                }
                R.id.menu_editar -> {

                }

            }



        return super.onOptionsItemSelected(item)
    }

    private fun RecebeDados() {
        intent.getParcelableExtra<Cadastro>("CHAVEDOPRODUTO")?.let { produtocarregado ->
            produto = produtocarregado
            CarregaOBJ(produtocarregado)


        }
    }

    private fun CarregaOBJ(produtocarregado: Cadastro) {
        binding.imgDadosItem.TentacarregarImagem(produtocarregado.imagem)
        binding.TVDadosItem.text = produtocarregado.email
        binding.TVDadosItem2.text = produtocarregado.phone.toString()
        binding.btDadosItem.text = produtocarregado.nome
    }
}