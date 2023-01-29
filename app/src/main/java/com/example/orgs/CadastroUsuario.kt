package com.example.orgs

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.example.orgs.adapter.lista.Cadastro
import com.example.orgs.databinding.LayoutDadosBinding
import com.example.orgs.databinding.LayoutDialogBinding
import java.math.BigDecimal

class CadastroUsuario : AppCompatActivity() {
    private val dao = DAO()
    private var url : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = LayoutDadosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val img = binding.imgCadastroUsuario
        val bt = binding.botao
        val binding_dialog = LayoutDialogBinding.inflate(layoutInflater)
        val buttDialog = binding_dialog.buttDialog
        buttDialog.setOnClickListener {
            url = binding_dialog.edtLayoutDialog.text.toString()
            binding_dialog.imgDialog.load(url)
        }

        img.setOnClickListener {
            AlertDialog.Builder(this)
                .setView(binding_dialog.root)
                .setPositiveButton("Confirmar") { _, _ ->
                    url = binding_dialog.edtLayoutDialog.text.toString()
                    binding.imgCadastroUsuario.load(url)
                }
                .setNegativeButton("Cancelar") { _, _ -> }
                .show()
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