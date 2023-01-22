package com.example.orgs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.orgs.adapter.lista.Cadastro
import java.math.BigDecimal

class CadastroUsuario : AppCompatActivity() {
    private val dao = DAO()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_dados)

        val bt = findViewById<Button>(R.id.botao)
        bt.setOnClickListener {
            val nome = findViewById<TextView>(R.id.cadastro_nome)
            val email = findViewById<TextView>(R.id.cadastro_email)
            val phone = findViewById<TextView>(R.id.cadastro_phone)
            val recuperanome = nome.text.toString()
            val recuperaemail = email.text.toString()
            val recuperaphone = phone.text.toString()
            val dadosphone = if (recuperaphone.isBlank()){
                BigDecimal.ZERO
            }
            else{
                recuperaphone.toBigDecimal()
            }
            val cadastro = Cadastro(recuperanome,recuperaemail, dadosphone)

            dao.adicionar(cadastro)
            finish()


        }
    }


}