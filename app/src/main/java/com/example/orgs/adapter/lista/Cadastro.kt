package com.example.orgs.adapter.lista

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal
@Parcelize
data class Cadastro (
    val nome : String,
    val email: String,
    val phone : BigDecimal,
    var imagem : String? = null,
        ) : Parcelable
