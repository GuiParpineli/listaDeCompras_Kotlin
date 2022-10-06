package br.com.livrokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val btnInserir = findViewById<Button>(R.id.btn_inserir)

        btnInserir.setOnClickListener {
            val produto = findViewById<EditText>(R.id.txt_produto)
            val qtd = findViewById<EditText>(R.id.txt_qtd)
            val valor = findViewById<EditText>(R.id.txt_valor)

            if (produto.text.isNotEmpty() && qtd.text.toString().isNotEmpty() && valor.text.toString()
                    .isNotEmpty()
            ) {
                val prod = Produto(
                    produto.text.toString(),
                    qtd.text.toString().toInt(),
                    valor.text.toString().toDouble()
                )
                produtosGlobal.add(prod)

                produto.text.clear()
                qtd.text.clear()
                valor.text.clear()

            } else {
                produto.error = if (produto.text.isEmpty()) "Preencha o nome do produto" else null
                qtd.error = if (qtd.text.isEmpty()) "Preencha a quantidade" else null
                valor.error = if (valor.text.isEmpty()) "Preencha o valor" else null
            }
        }
    }
}