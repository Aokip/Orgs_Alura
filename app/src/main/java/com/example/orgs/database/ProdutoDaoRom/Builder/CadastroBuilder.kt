package com.example.orgs.database.ProdutoDaoRom.Builder

import android.content.Context
import androidx.room.Room
import com.example.orgs.database.ProdutoDaoRom.AppDataBase
import com.example.orgs.database.ProdutoDaoRom.ProdutoDaoRom

class CadastroBuilder {
    /*
  Chamada do Room build para construir as chamadas diretamente do APPDataBase
   */
    fun buider(context: Context): ProdutoDaoRom {
        val db = Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "Orgs.bd"

        ).allowMainThreadQueries()
            .build()
        /*
        faz a chamada da variavel db e instancia o "databaseProduto" dentro da classe
        "AppDataBase" onde possui os conversores e a função "databaseProduto" que faz um extensão da
        interface "ProdutosDaoRom" onde possui as Querys
         */
        return db.databaseProduto()

    }


}