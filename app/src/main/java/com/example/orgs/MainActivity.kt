package com.example.orgs

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.adapter.ListaDeDadosAdapter
import com.example.orgs.adapter.lista.Cadastro
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private val dao = DAO()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onResume() {
        super.onResume()
        Log.i("teste", "onResume: ${dao.buscatodos()}")
        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.adapter = ListaDeDadosAdapter(itens = dao.buscatodos())
        rv.layoutManager = LinearLayoutManager(this)
        val fltAct = findViewById<FloatingActionButton>(R.id.floating_act)
        fltAct.setOnClickListener {
            val intente = Intent(this, CadastroUsuario::class.java)
            startActivity(intente)
        }
    }
}