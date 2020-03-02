package br.com.etelimoeiro.projetointegrador.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import br.com.etelimoeiro.projetointegrador.R;
import br.com.etelimoeiro.projetointegrador.domain.Produto;

public class EditarProdutosActivity extends AppCompatActivity {

    private EditText edtIdProduto;
    private EditText edtNomeProduto;
    private EditText edtQuantidadeProduto;
    private EditText edtValorProduto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_produtos);

        this.edtIdProduto = (EditText) findViewById(R.id.edtIdProduto);
        this.edtNomeProduto = (EditText) findViewById(R.id.edtNomeProduto);
        this.edtQuantidadeProduto = (EditText) findViewById(R.id.edtQuantidadeProduto);
        this.edtValorProduto = (EditText) findViewById(R.id.edtValorProduto);

        Bundle bundleDadosProduto = getIntent().getExtras();

        Produto produto = new Produto();

        produto.setId(bundleDadosProduto.getLong("id_produto"));
        produto.setNomeProduto(bundleDadosProduto.getString("nome_produto"));
        produto.setQtd(bundleDadosProduto.getInt("qtd_produto"));
        produto.setValor(bundleDadosProduto.getDouble("valor_produto"));

        this.setDadosProduto(produto);

    }

    private void setDadosProduto(Produto produto){

        this.edtIdProduto.setText(String.valueOf(produto.getId()));
        this.edtNomeProduto.setText(produto.getNomeProduto());
        this.edtQuantidadeProduto.setText(String.valueOf(produto.getQtd()));
        this.edtValorProduto.setText(String.valueOf(produto.getValor()));
    }

}
