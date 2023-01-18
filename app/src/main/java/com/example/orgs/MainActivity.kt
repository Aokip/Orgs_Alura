package com.example.orgs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.adapter.ListaDeDadosAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv = findViewById<RecyclerView>(R.id.rv)
        /* configuração do RecyclerView incluindo o Adapter */
        rv.adapter = ListaDeDadosAdapter()
        rv.layoutManager = LinearLayout(this)
    }
}