package com.example.orgs

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import coil.imageLoader
import coil.load
import com.example.orgs.adapter.lista.Cadastro
import com.example.orgs.database.ProdutoDaoRom.Builder.CadastroBuilder
import com.example.orgs.databinding.LayoutDadosBinding
import com.example.orgs.databinding.LayoutDialogBinding
import com.example.orgs.extenx.TentacarregarImagem
import java.math.BigDecimal

class CadastroUsuario : AppCompatActivity() {
    private val dao = CadastroBuilder()
    private var url: String? = null
    private var id = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = LayoutDadosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Cadastro"
        val img = binding.imgCadastroUsuario
        val bt = binding.botao
        /* Utilizado a função de clique no formulario de cadastro
        - chamado a classe "AbreDialog" enviando o context atual
        - Chamado a função "mostra" onde Abre o Dialog -> Carrega a imagem na ação da função
        e envia a url do listener por highorder na propria chamada da função.
         */
        img.setOnClickListener {
            /*
            função mostra recuperando a URL do formulario de cadastro
            - caso a URL for null será apresentado uma imagem vazio
            - Caso a imagem do cadastro estiver com uma URL será carregada no dialogo
             */
            AbreDialog(this).mostra(url) { imagem ->
                url = imagem
                binding.imgCadastroUsuario.TentacarregarImagem(url)

            }
        }

        AdicionaCadastro(bt)

        intent.getParcelableExtra<Cadastro>("CADASTRO")?.let { produtoCarregado ->
            title = "Editar Cadastro"
            id = produtoCarregado.id
            binding.imgCadastroUsuario.TentacarregarImagem(produtoCarregado.imagem)
            /*
            envia na URL novamente a URL do produto, visto que a implementação para salvamento da img está atrelado na variavel url
             */
            url = produtoCarregado.imagem
            binding.cadastroNome.setText(produtoCarregado.nome)
            binding.cadastroEmail.setText(produtoCarregado.email)
            binding.cadastroPhone.setText(produtoCarregado.phone.toPlainString())


        }

    }


    private fun AdicionaCadastro(bt: Button) {
        bt.setOnClickListener {
            val nome = findViewById<TextView>(R.id.cadastro_nome)
            val email = findViewById<TextView>(R.id.cadastro_email)
            val phone = findViewById<TextView>(R.id.cadastro_phone)
            val recuperanome = nome.text.toString()
            val recuperaemail = email.text.toString()
            val recuperaphone = phone.text.toString()
            val dadosphone = if (recuperaphone.isBlank()) {
                BigDecimal.ZERO
            } else {
                recuperaphone.toBigDecimal()
            }

            val cadastro = Cadastro(nome = recuperanome, email = recuperaemail, phone = dadosphone, id = id)

            val buider = dao.buider(this)
            /*
            faz a condição utilizando a property id, onde se o id for maior que "0" a função do DAO é atualiza
            caso clicar no bt de salvar e o id for menor ou igual a 0 a função acionada do DAO é o Salva.
             */
            if (id > 0){
                buider.atualiza(cadastro)
            }
            else{
                buider.salva(cadastro)
            }


            finish()


        }
    }


}