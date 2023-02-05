package com.example.orgs

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.example.orgs.databinding.LayoutDialogBinding
import com.example.orgs.extenx.TentacarregarImagem

class AbreDialog(private val context: Context) {
    fun mostra(CarregaURL: (imagem: String) -> Unit) {
        val binding_dialog = LayoutDialogBinding.inflate(LayoutInflater.from(context))
        val buttDialog = binding_dialog.buttDialog.setOnClickListener {
            val url = binding_dialog.edtLayoutDialog.text.toString()
            binding_dialog.imgDialog.TentacarregarImagem(url)

            /* Dialog abrindo ao clicar na imagem do cadastro */
            AlertDialog.Builder(context)
                .setView(binding_dialog.root)
                .setPositiveButton("Confirmar") { _, _ ->
                    /* Ao clicar no botão confirmar é carregado a imagem no cadastro do usuário, sem o dialog */
                    val url = binding_dialog.edtLayoutDialog.text.toString()
                    CarregaURL(url)


                }
                .setNegativeButton("Cancelar") { _, _ -> }
                .show()

        }

    }


}