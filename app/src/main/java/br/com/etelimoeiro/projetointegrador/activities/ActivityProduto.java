package br.com.etelimoeiro.projetointegrador.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import br.com.etelimoeiro.projetointegrador.R;
import br.com.etelimoeiro.projetointegrador.domain.Produto;

public class ActivityProduto extends AppCompatActivity {

    private EditText edtNomeProduto;
    private EditText edtQuantidadeProduto;
    private EditText edtValorProduto;

    private Button btnSalvarProduto;

    private Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        edtNomeProduto = (EditText) findViewById(R.id.edtNomeProduto);
        edtQuantidadeProduto = (EditText) findViewById(R.id.edtQuantidadeProduto);
        edtValorProduto = (EditText) findViewById(R.id.edtValorProduto);

        btnSalvarProduto = (Button) findViewById(R.id.btnSalvarProduto);
    }

    private Produto getProdutosFormulário() {
        this.produto = new Produto();

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
