package br.com.etelimoeiro.projetointegrador.controller;

import br.com.etelimoeiro.projetointegrador.dao.ProdutoDAO;
import br.com.etelimoeiro.projetointegrador.db.ConexaoSQL;
import br.com.etelimoeiro.projetointegrador.domain.Produto;


public class ProdutoController {

    private final ProdutoDAO produtoDAO;

    public ProdutoController(ConexaoSQL conexao) {
        produtoDAO = new ProdutoDAO(conexao);
    }

    public long salvarProduto(Produto produto) {
        return this.produtoDAO.salvarProduto(produto);
    }

}
