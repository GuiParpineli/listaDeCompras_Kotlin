package br.com.livrokotlin

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import java.text.NumberFormat
import java.util.*

class ProdutoAdapter(contexto: Context) : ArrayAdapter<Produto>(contexto, 0) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val v: View

        if (convertView != null) {
            v = convertView
        } else {
            v = LayoutInflater.from(context).inflate(R.layout.list_view_item, parent, false)
        }

        val item = getItem(position)

        val txtProduto = v.findViewById<TextView>(R.id.txt_item_produto)
        val txtQtd = v.findViewById<TextView>(R.id.txt_item_qtd)
        val txtValor = v.findViewById<TextView>(R.id.txt_item_valor)
        val imgProduto = v.findViewById<ImageView>(R.id.img_item_foto)

        txtQtd.text = item?.quantidade.toString()
        txtProduto.text = item?.nome
        txtValor.text = item?.valor.toString()

        val f = NumberFormat.getCurrencyInstance(Locale("pt","br"))
        txtValor.text = f.format(item?.valor)

        if(item !=null)
            imgProduto.setImageBitmap(item.foto)

        return v
    }

}