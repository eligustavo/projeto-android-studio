package br.com.etelimoeiro.projetointegrador.domain;

import java.util.Date;

public class Venda {

    private int id;
    private Produto produto;
    private Date dataVenda;
    private String nomeCliente;

    public Venda(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", produto=" + produto.toString() +
                ", dataVenda=" + dataVenda +
                ", nomeCliente='" + nomeCliente + '\'' +
                '}';
    }
}
