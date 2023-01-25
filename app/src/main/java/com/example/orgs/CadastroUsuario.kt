package com.example.orgs

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.orgs.adapter.lista.Cadastro
import java.math.BigDecimal

class CadastroUsuario : AppCompatActivity() {
    private val dao = DAO()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_dados)
        val img = findViewById<ImageView>(R.id.img_cadastro_usuario)
        val bt = findViewById<Button>(R.id.botao)
        AdicionaCadastro(bt)
        AbreDialog(img)
    }




    private fun AbreDialog(img: ImageView) {
        img.setOnClickListener {
            AlertDialog.Builder(this)
                .setView(R.layout.layout_dialog)
                .setPositiveButton("Confirmar") { _, _ -> }
                .setNegativeButton("Cancelar") { _, _ -> }
                .show()
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
            val cadastro = Cadastro(recuperanome, recuperaemail, dadosphone)

            dao.adicionar(cadastro)
            finish()


        }
    }


}