package br.com.etelimoeiro.projetointegrador.domain;

public class ItemVenda {

    private long id;
    private String nome;
    private int qtdSelecionada;
    private Double valorProduto;
    private Double valorItemVenda;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdSelecionada() {
        return qtdSelecionada;
    }

    public void setQtdSelecionada(int qtdSelecionada) {
        this.qtdSelecionada = qtdSelecionada;
    }

    public Double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(Double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public Double getValorItemVenda() {
        return valorItemVenda;
    }

    public void setValorItemVenda(Double valorItemVenda) {
        this.valorItemVenda = valorItemVenda;
    }
}
