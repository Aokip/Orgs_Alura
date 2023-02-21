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
import com.example.orgs.databinding.LayoutDadosBinding
import com.example.orgs.databinding.LayoutDialogBinding
import com.example.orgs.extenx.TentacarregarImagem
import java.math.BigDecimal

class CadastroUsuario : AppCompatActivity() {
    private val dao = DAO()
    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = LayoutDadosBinding.inflate(layoutInflater)
        setContentView(binding.root)
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

            val cadastro = Cadastro(recuperanome, recuperaemail, dadosphone, url)

            dao.adicionar(cadastro)
            finish()


        }
    }


}