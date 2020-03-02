package br.com.etelimoeiro.projetointegrador.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.etelimoeiro.projetointegrador.R;
import br.com.etelimoeiro.projetointegrador.controller.ProdutoController;
import br.com.etelimoeiro.projetointegrador.db.ConexaoSQL;
import br.com.etelimoeiro.projetointegrador.domain.Produto;

public class ActivityProduto extends AppCompatActivity {

    private EditText edtIdProduto;
    private EditText edtNomeProduto;
    private EditText edtQuantidadeProduto;
    private EditText edtValorProduto;

    private Button btnSalvarProduto;

    private Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        edtIdProduto = (EditText) findViewById(R.id.edtIdProduto);
        edtNomeProduto = (EditText) findViewById(R.id.edtNomeProduto);
        edtQuantidadeProduto = (EditText) findViewById(R.id.edtQuantidadeProduto);
        edtValorProduto = (EditText) findViewById(R.id.edtValorProduto);

        btnSalvarProduto = (Button) findViewById(R.id.btnSalvarProduto);

        this.clickBotaoSalvarListener();

    }

    private void clickBotaoSalvarListener() {

        this.btnSalvarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Produto produtoCadastro = getProdutosFormulário();

                if (produtoCadastro != null) {

                    ProdutoController produtoController = new ProdutoController(ConexaoSQL.getInstancia(ActivityProduto.this));
                    long idProduto = produtoController.salvarProduto(produtoCadastro);

                    if (idProduto > 0) {
                        Toast.makeText(ActivityProduto.this, "Produto salvo com sucesso", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(ActivityProduto.this, "Produto não pode ser salvo", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(ActivityProduto.this, "Todos os campos são obrigatórios!", Toast.LENGTH_LONG).show();
                }

            }
        });

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
}
