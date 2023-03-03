package com.example.orgs.database.ProdutoDaoRom

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [ProdutoDaoRom::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun databaseProduto() : ProdutoDaoRom
}