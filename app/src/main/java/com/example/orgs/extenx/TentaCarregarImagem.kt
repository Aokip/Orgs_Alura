package com.example.orgs.extenx

import android.widget.ImageView
import coil.load
import com.example.orgs.R

/* Cadastro de função separada dos xml visto que não é dependente do layout
função carrega o load do coil e utiliza o fallback e o error para preencher caso os dados não
forem fornecidos ou forem invalidos

 */
fun ImageView.TentacarregarImagem(url: String? = null) {
    load(url) {
        fallback(R.drawable.magiccarta)
        error(R.drawable.magiccarta)
        placeholder(R.drawable.placeholder)


    }
}
