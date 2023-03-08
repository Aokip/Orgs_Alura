package com.example.orgs.database.ProdutoDaoRom

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.orgs.adapter.lista.Cadastro
import com.example.orgs.database.ProdutoDaoRom.Conversores.Conversores


@Database(entities = [Cadastro::class], version = 1, exportSchema = false)
/*
Cria a anotação "@TypeConverters" para que o kotlin ajuste a classe Conversores para o database
 */
@TypeConverters(Conversores::class)
abstract class AppDataBase: RoomDatabase() {
    /*
    Cria uma função abstrata que faz a extensão da classe ProdutoDAOROM
     */
    abstract fun databaseProduto() : ProdutoDaoRom
}