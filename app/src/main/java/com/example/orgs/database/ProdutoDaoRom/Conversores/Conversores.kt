package com.example.orgs.database.ProdutoDaoRom.Conversores

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.math.BigDecimal

class Conversores {
    /*
    Converte o valor do bd de Double para BigDecimal ao ser chamada/apresentada no APP
    Retorno se o valor for diferente de null, recebe em BigDecimal o valor informado no BD
    Caso o valor for nulo " ?: " -> Converte a função em Zero, para não "quebrar o APP"
     */
    @TypeConverters
    fun deDouble(valor: Double?): BigDecimal {
        return valor?.let {
            BigDecimal(valor.toString())
        } ?: BigDecimal.ZERO
    }

    /*
    Converte o valor informado no APP que está em BigDecimal para Double visto que o sqlite aceita alguns
    tipos de valores, desta forma converte o BigDecimal para Double para ser salvo no BD.
    O Double é um tipo que aceita o nulo então não precisa realizar um tratamento caso o valor for nulo, igual
    a função "deDouble".
     */
    @TypeConverters
    fun deBigDecimal(valor: BigDecimal?): Double? {
        return valor?.let {
            valor.toDouble()
        }

    }
}