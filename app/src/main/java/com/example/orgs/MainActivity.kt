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

    }

    override fun onResume() {
        super.onResume()
        val dao = DAO()
        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.adapter = ListaDeDadosAdapter(dao.bucatodos())
        rv.layoutManager = LinearLayoutManager(this)
    }
}