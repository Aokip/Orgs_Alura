package com.example.orgs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.orgs.adapter.lista.Cadastro
import java.math.BigDecimal

class CadastroUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_dados)
        val nome = findViewById<TextView>(R.id.edt_nome)
        val email = findViewById<TextView>(R.id.edt_email)
        val phone = findViewById<TextView>(R.id.edt_phone)
        val bt = findViewById<Button>(R.id.botao)
        bt.setOnClickListener {
            val recuperanome = nome.text.toString()
            val recuperaemail = email.text.toString()
            val recuperaphone = phone.text.toString()
            val cadastro = Cadastro(recuperanome,recuperaemail, BigDecimal(recuperaphone))
            val dao = DAO()
            dao.adicionar(cadastro)
            finish()


        }
    }


}