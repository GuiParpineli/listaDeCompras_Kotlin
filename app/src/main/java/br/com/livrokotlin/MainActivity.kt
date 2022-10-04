package br.com.livrokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)

        val listProducts = findViewById<ListView>(R.id.list_view_produtos)
        val btnInserir = findViewById<Button>(R.id.btn_inserir)

        listProducts.adapter = produtosAdapter

        btnInserir.setOnClickListener {
            val produto = findViewById<EditText>(R.id.txt_produto)
            if (produto.text.isNotEmpty()) {
                produtosAdapter.add(produto.text.toString())
                produto.text.clear()
            } else {
                produto.error = "Preencha um valor"
            }
        }
        listProducts.setOnItemLongClickListener { adpaterView: AdapterView<*>, view: View, position: Int, id: Long ->
            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)
            true
        }
    }
}