package br.com.etelimoeiro.projetointegrador.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import br.com.etelimoeiro.projetointegrador.R;
import br.com.etelimoeiro.projetointegrador.controller.ProdutoController;
import br.com.etelimoeiro.projetointegrador.db.ConexaoSQL;
import br.com.etelimoeiro.projetointegrador.domain.Produto;

public class ActivityVenda extends AppCompatActivity {

    private Spinner spnProdutos;
    private List<Produto> listaProduto;
    private ProdutoController produtoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venda);

        this.produtoController = new ProdutoController((ConexaoSQL.getInstancia(this)));
        this.listaProduto = this.produtoController.getListaProdutosController();

        this.spnProdutos = (Spinner) this.findViewById(R.id.spnProduto);
        ArrayAdapter<Produto> spnProdutoAdapter = new ArrayAdapter<Produto>(this,
                android.R.layout.simple_spinner_item,
                this.listaProduto
                );

        this.spnProdutos.setAdapter(spnProdutoAdapter);

    }
}
