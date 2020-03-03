package br.com.etelimoeiro.projetointegrador.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.etelimoeiro.projetointegrador.R;
import br.com.etelimoeiro.projetointegrador.controller.ProdutoController;
import br.com.etelimoeiro.projetointegrador.db.ConexaoSQL;
import br.com.etelimoeiro.projetointegrador.domain.Produto;

public class EditarProdutosActivity extends AppCompatActivity {

    private EditText edtIdProduto;
    private EditText edtNomeProduto;
    private EditText edtQuantidadeProduto;
    private EditText edtValorProduto;

    private Button btnSalvarAlteracoes;

    private Produto produto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_produtos);

        this.edtIdProduto = (EditText) findViewById(R.id.edtIdProduto);
        this.edtNomeProduto = (EditText) findViewById(R.id.edtNomeProduto);
        this.edtQuantidadeProduto = (EditText) findViewById(R.id.edtQuantidadeProduto);
        this.edtValorProduto = (EditText) findViewById(R.id.edtValorProduto);

        this.btnSalvarAlteracoes = (Button) findViewById(R.id.btnSalvarProduto);

        Bundle bundleDadosProduto = getIntent().getExtras();

        Produto produto = new Produto();

        produto.setId(bundleDadosProduto.getLong("id_produto"));
        produto.setNomeProduto(bundleDadosProduto.getString("nome_produto"));
        produto.setQtd(bundleDadosProduto.getInt("qtd_produto"));
        produto.setValor(bundleDadosProduto.getDouble("valor_produto"));

        this.setDadosProduto(produto);

        this.clickBotaoSalvarListener();

    }

    private void setDadosProduto(Produto produto) {

        this.edtIdProduto.setText(String.valueOf(produto.getId()));
        this.edtNomeProduto.setText(produto.getNomeProduto());
        this.edtQuantidadeProduto.setText(String.valueOf(produto.getQtd()));
        this.edtValorProduto.setText(String.valueOf(produto.getValor()));
    }

    private Produto getProdutosFormulário() {

        this.produto = new Produto();

        if (this.edtIdProduto.getText().toString().isEmpty() == false) {
            this.produto.setId(Integer.parseInt(this.edtIdProduto.getText().toString()));
        } else {
            return null;
        }

        if (this.edtNomeProduto.getText().toString().isEmpty() == false) {
            this.produto.setNomeProduto(this.edtNomeProduto.getText().toString());
        } else {
            return null;
        }

        if (edtQuantidadeProduto.getText().toString().isEmpty() == false) {
            int qtd = Integer.parseInt(this.edtQuantidadeProduto.getText().toString());
            this.produto.setQtd(qtd);
        } else {
            return null;
        }

        if (edtValorProduto.getText().toString().isEmpty() == false) {
            double valor = Double.parseDouble(this.edtValorProduto.getText().toString());
            this.produto.setValor(valor);
        } else {
            return null;
        }

        return produto;

    }

    private void clickBotaoSalvarListener() {

        this.btnSalvarAlteracoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Produto produtoAtualizar = getProdutosFormulário();

                Log.d("PRODUTO RECUP. ", produtoAtualizar.toString());

                if (produtoAtualizar != null) {

                    ProdutoController produtoController = new ProdutoController(ConexaoSQL.getInstancia(EditarProdutosActivity.this));
                    boolean atualizou = produtoController.atualizarProdutoController(produtoAtualizar);

                    if (atualizou == true) {
                        Toast.makeText(EditarProdutosActivity.this, "Produto salvo com sucesso", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(EditarProdutosActivity.this, "Produto não pode ser salvo", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(EditarProdutosActivity.this, "Todos os campos são obrigatórios!", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

}
