package br.com.etelimoeiro.projetointegrador.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

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

            long idProdutoInserido = db.insert("tbproduto", null, values);

            return idProdutoInserido;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
        }
        return 0;
    }

    public List<Produto> getListaProdutosDAO() {

        List<Produto> listaProdutos = new ArrayList<>();

        SQLiteDatabase db = null;
        Cursor cursor;

        String queryConsulta = "SELECT * FROM tbproduto;";

        try {

            db = this.conexao.getReadableDatabase();

            cursor = db.rawQuery(queryConsulta, null);

            if (cursor.moveToFirst()) {

                Produto produto = new Produto();

                do {

                    produto = new Produto();
                    produto.setId(cursor.getLong(0));
                    produto.setNomeProduto(cursor.getString(1));
                    produto.setQtd(cursor.getInt(2));
                    produto.setValor(cursor.getDouble(3));

                    listaProdutos.add(produto);

                } while (cursor.moveToNext());

            }

        } catch (Exception e) {
            Log.d("ERRO LISTA DE PRODUTOS", "Erro ao retornar os produtos");
            return null;
        } finally {
            if (db != null) {
                db.close();
            }
        }
        return listaProdutos;
    }

    public boolean excluirProdutoDAO(long idProduto) {
        SQLiteDatabase db = null;

        try {

            db = this.conexao.getWritableDatabase();

            db.delete(
                    "tbproduto",
                    "id = ?",
                    new String[]{String.valueOf(idProduto)}
            );

        } catch (Exception e) {
            Log.d("PRODUTODAO", "Não foi possível deletar um produto");
            return false;
        } finally {
            if (db != null) {
                db.close();
            }
        }
        return true;
    }

}
