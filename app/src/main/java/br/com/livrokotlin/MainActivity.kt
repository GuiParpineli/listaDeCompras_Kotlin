package br.com.livrokotlin

import android.content.Intent
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

        val produtosAdapter = ProdutoAdapter(this)

        val listProducts = findViewById<ListView>(R.id.list_view_produtos)
        val btnAdicionar = findViewById<Button>(R.id.btn_adicionar)

        btnAdicionar.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        listProducts.adapter = produtosAdapter

        listProducts.setOnItemLongClickListener { adpaterView: AdapterView<*>, view: View, position: Int, id: Long ->
            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)
            true
        }
    }

    override fun onResume(){
        super.onResume()
        val adapter = findViewById<ListView>(R.id.list_view_produtos).adapter as ProdutoAdapter
        adapter.clear()
        adapter.addAll(produtosGlobal)
    }
}