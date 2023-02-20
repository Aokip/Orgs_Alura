package com.example.orgs.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.orgs.R
import com.example.orgs.adapter.lista.Cadastro

class ListaDeDadosAdapter(
    private val itens: List<Cadastro>,
    /*
    criado a variavel quandoclicanoitem como um tipo função, para utilizar expressão lambda em suas
    chamadas, desta forma ao clicar em um item do RV teremos o objeto do Cadastro.
     */
    var quandoclicanoItem: (produto: Cadastro) -> Unit = {}
) : RecyclerView.Adapter<ListaDeDadosAdapter.ViewHolder>() {
    inner class ViewHolder(Listview: View) : RecyclerView.ViewHolder(Listview) {
        /*
        cria uma variavel para ser inicializada depois
         */
        private lateinit var produto: Cadastro

        /*
        inicia e faz a checagem se o produto foi inicializado recuperando os dados do obj
         */
        init {
            itemView.setOnClickListener {
                if (::produto.isInitialized)
                    quandoclicanoItem(produto)
            }
        }

        fun bindview(produto: Cadastro) {
            /*
            informa que o produto enviado é o do Cadastro
             */
            this.produto
            /* Ligação entre a lista "Cadastro" com os edt do "layout_dados" */
            val nome = itemView.findViewById<TextView>(R.id.edt_nome_dados)
            val email = itemView.findViewById<TextView>(R.id.edt_email_dados)
            val phone = itemView.findViewById<TextView>(R.id.edt_phone_dados)
            val img = itemView.findViewById<ImageView>(R.id.img_rv_dados)


            nome.text = produto.nome
            email.text = produto.email
            phone.text = produto.phone.toString()
            img.load(produto.url)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate =
            LayoutInflater.from(parent.context).inflate(R.layout.listadeitens_rv, parent, false)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val posicaoLista = itens[position]
        holder.bindview(posicaoLista)

    }

    override fun getItemCount() = itens.size

}
