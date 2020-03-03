package br.com.etelimoeiro.projetointegrador.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.etelimoeiro.projetointegrador.R;
import br.com.etelimoeiro.projetointegrador.adapters.ListaProdutosAdapter;
import br.com.etelimoeiro.projetointegrador.controller.ProdutoController;
import br.com.etelimoeiro.projetointegrador.db.ConexaoSQL;
import br.com.etelimoeiro.projetointegrador.domain.Produto;

public class ListaProdutosActivity extends AppCompatActivity {

    private ListView lsvProdutos;
    private List<Produto> produtoList;
    private ListaProdutosAdapter adapterListaProdutos;
    private ProdutoController produtoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);

        this.produtoController = new ProdutoController(ConexaoSQL.getInstancia(ListaProdutosActivity.this));

        produtoList = produtoController.getListaProdutosController();

        this.lsvProdutos = (ListView) findViewById(R.id.lsvListaProdutos);

        this.adapterListaProdutos = new ListaProdutosAdapter(ListaProdutosActivity.this, this.produtoList);

        this.lsvProdutos.setAdapter(this.adapterListaProdutos);

        this.lsvProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                final Produto produtoSelecionado = (Produto) adapterListaProdutos.getItem(position);

                AlertDialog.Builder janelaEscolha = new AlertDialog.Builder(ListaProdutosActivity.this);

                janelaEscolha.setTitle("Escolha: ");
                janelaEscolha.setMessage("O que deseja fazer com o produto?");

                janelaEscolha.setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

                janelaEscolha.setNegativeButton("Excluir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        boolean excluiu = produtoController.excluirProdutoController(produtoSelecionado.getId());

                        dialog.cancel();

                        if (excluiu == true) {

                            adapterListaProdutos.removerProduto(position);

                            Toast.makeText(ListaProdutosActivity.this, "Produto excluido com sucesso!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ListaProdutosActivity.this, "Erro ao excluir produto!", Toast.LENGTH_SHORT).show();
                        }


                    }
                });

                janelaEscolha.setPositiveButton("Editar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Bundle bundleDadosProduto = new Bundle();

                        bundleDadosProduto.putLong("id_produto", produtoSelecionado.getId());
                        bundleDadosProduto.putString("nome_produto", produtoSelecionado.getNomeProduto());
                        bundleDadosProduto.putInt("qtd_produto", produtoSelecionado.getQtd());
                        bundleDadosProduto.putDouble("valor_produto", produtoSelecionado.getValor());

                        Intent intentEditar = new Intent(ListaProdutosActivity.this, EditarProdutosActivity.class);
                        intentEditar.putExtras(bundleDadosProduto);
                        startActivity(intentEditar);

                    }
                });

                janelaEscolha.create().show();

            }
        });

    }

    public void eventAtualizarProd(View v) {
        this.adapterListaProdutos.Atualizar(this.produtoController.getListaProdutosController());
    }

}
