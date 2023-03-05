package com.example.orgs

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.orgs.adapter.ListaDeDadosAdapter
import com.example.orgs.adapter.lista.Cadastro
import com.example.orgs.database.ProdutoDaoRom.AppDataBase
import com.example.orgs.database.ProdutoDaoRom.Builder.CadastroBuilder
import com.example.orgs.database.ProdutoDaoRom.ProdutoDaoRom
import com.example.orgs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val dao = CadastroBuilder().buider(this)

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }

    override fun onResume() {
        super.onResume()
        AbreCadastro()
        val recycler = binding.rv
        val listaDeDadosAdapter = ListaDeDadosAdapter(dao.buscatodos())
        recycler.adapter = listaDeDadosAdapter
        recycler.layoutManager = LinearLayoutManager(this)
        /*
        acessa a variavel "quandoclicanoitem" para recuperar o objt do rv, implementa a função lambda para chamadas
        cadeadas
*/
        listaDeDadosAdapter.quandoclicanoItem = {
            val intent = Intent(this, Dadositem::class.java)
            intent.apply {
                putExtra("CHAVEDOPRODUTO", it)
                startActivity(intent)
            }


        }


    }

    private fun AbreCadastro() {
        val fltAct = binding.floatingAct
        fltAct.setOnClickListener {
            val intente = Intent(this, CadastroUsuario::class.java)
            startActivity(intente)
        }
    }
}