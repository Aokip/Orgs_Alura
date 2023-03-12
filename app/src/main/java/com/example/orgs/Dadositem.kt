package com.example.orgs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.orgs.adapter.lista.Cadastro
import com.example.orgs.database.ProdutoDaoRom.Builder.CadastroBuilder
import com.example.orgs.databinding.ActivityDadosItemBinding
import com.example.orgs.extenx.TentacarregarImagem

class Dadositem : AppCompatActivity() {
    private var produtoid: Long? = null
    private var produto: Cadastro? = null
    private val binding by lazy {
        ActivityDadosItemBinding.inflate(layoutInflater)
    }
    /*
    inicia uma variavel em lazy visto que será utilizado para buscar o id e na ação de remover,
    deixando o código mais limpo.
     */
    private val buider by lazy {
        CadastroBuilder().buider(this)
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

    override fun onResume() {
        super.onResume()
        /*
        chama a variavl "produtoid" inicializada caso exista um obj a ser apresentado ->
        Inicializado na Intent onde é recebido o id
        faz a chamada no ROOM através da função do "buscaporID", armazena o id na variavel produto ->
        Faz um safecall se o produto for diferente de nulo, chama a função para preencher os campos, conforme
        o id enviado.
         */
        produtoid?.let { idproduto ->
          produto = buider.buscaporID(idproduto)
        }
        produto?.let {
            CarregaOBJ(it)

        }

        ?: finish()
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
                - Alterado a condição de initialized para o let, visto que será utilizado com o vinculo do BD para
                a verificação e tratamento do não nulo, com o .let faz a checagem correta se o cadastro for nulo
                enviando o cadastro caso não for utilizando o "it", conseguindo confirmar que o valor não é null
                 */
                produto?.let {
                    buider.deleta(it)
                    finish()
                }
            }


            R.id.menu_editar -> {
                /*
                Ao clicar no campo editar, será enviado o cadastro para a actv de cadstro preenchendo
                os campos conforme o ID
                 */
                Intent(this, CadastroUsuario::class.java).apply {
                    putExtra("CADASTRO", produto)
                    startActivity(this)
                }

            }



        }
        return super.onOptionsItemSelected(item)
    }

    /*
    função para receber os dados da Main, quando clicado no obj
     */
    private fun RecebeDados() {
        intent.getParcelableExtra<Cadastro>("CHAVEDOPRODUTO")?.let { produtocarregado ->
            produtoid = produtocarregado.id




        }
    }

    /*
    Função para prencher os campos na actv de detalhes e edição.
     */
    private fun CarregaOBJ(produtocarregado: Cadastro) {
        binding.imgDadosItem.TentacarregarImagem(produtocarregado.imagem)
        binding.TVDadosItem.text = produtocarregado.email
        binding.TVDadosItem2.text = produtocarregado.phone.toString()
        binding.btDadosItem.text = produtocarregado.nome
    }
}