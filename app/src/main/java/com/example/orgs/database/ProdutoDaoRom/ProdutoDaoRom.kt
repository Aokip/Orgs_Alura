package com.example.orgs.database.ProdutoDaoRom

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.orgs.adapter.lista.Cadastro


@Dao
/*
Para o DAO criamos um interface para comunicar nas chamadas, mas não é uma classe para ser implementada
com suas funções
 */
 interface ProdutoDaoRom {
    @Query("SELECT * FROM Cadastro")
   fun buscatodos(): List<Cadastro>

   /*
   utilizando o insert para determinar o salvamento do objs
   tipo -> vararg é utilizado para salvar um ou mais registros na mesma chamada.
    */
   @Insert
   fun salva(vararg cadastro: Cadastro)

   @Delete
   fun deleta(vararg cadastro: Cadastro)

   @Update
   fun atualiza(vararg cadastro: Cadastro)


}