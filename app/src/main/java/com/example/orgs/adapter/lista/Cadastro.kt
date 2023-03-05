package com.example.orgs.adapter.lista

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal
@Parcelize
@Entity
data class Cadastro(
    /*
    Criado a chave primaria para determinar qual informação será cadastrado do produto
    incluido o autogerate para que o kotlin gere automaticamente um Id diferente para cadas produto.
    Iniciado em 0L para cada produto novo que for incluido em 0L o autogerate irá sequenciar.
     */
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val nome: String,
    val email: String,
    val phone: BigDecimal,
    var imagem: String? = null,
        ) : Parcelable
