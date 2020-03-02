package br.com.etelimoeiro.projetointegrador.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import br.com.etelimoeiro.projetointegrador.db.ConexaoSQL;
import br.com.etelimoeiro.projetointegrador.domain.Produto;

public class ProdutoDAO {

    private final ConexaoSQL conexao;

    public ProdutoDAO(ConexaoSQL conexao) {
        this.conexao = conexao;
    }

    public long salvarProduto(Produto produto) {

        SQLiteDatabase db = conexao.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put("id", produto.getId());
            values.put("nomeProduto", produto.getNomeProduto());
            values.put("qtd", produto.getQtd());
            values.put("valor", produto.getValor());

           long idProdutoInserido =  db.insert("produto", null, values);

           return idProdutoInserido;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
