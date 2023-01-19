package com.example.orgs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.adapter.ListaDeDadosAdapter
import com.example.orgs.adapter.lista.Cadastro
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv = findViewById<RecyclerView>(R.id.rv)
        /* configuração do RecyclerView incluindo o Adapter */
        val lista = listOf<Cadastro>(Cadastro(nome="oi", email= "oi", phone= BigDecimal("1254")))
        rv.adapter = ListaDeDadosAdapter(lista)
        rv.layoutManager = LinearLayoutManager(this)
    }
}