package br.com.etelimoeiro.projetointegrador.domain;

public class Produto {

    private int id;
    private String nomeProduto;
    private int qtd;
    private Double valor;

    public Produto(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", qtd=" + qtd +
                ", valor=" + valor +
                '}';
    }
}
