package com.example.orgs.database.ProdutoDaoRom

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [ProdutoDaoRom::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    /*
    Cria uma função abstrata que faz a extensão da classe ProdutoDAOROM
     */
    abstract fun databaseProduto() : ProdutoDaoRom
}