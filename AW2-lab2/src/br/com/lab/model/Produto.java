package br.com.lab.model;

public class Produto {

    private String nome;
    private String marca;
    private double preco;
    private int id;

    public Produto(String nome, String marca, double preco) {
        this.setNome(nome);
        this.setMarca(marca);
        this.setPreco(preco);
    }

    public Produto(int id, String nome, String marca, double preco) {
        this(nome, marca, preco);
        this.setId(id);
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String desc) {
        this.marca = desc;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    @Override
    public String toString() {
        String pNome = " Nome     :" + this.getNome() + "\n";
        String pId = " ID    :" + this.getId() + "\n";
        String pMarca = " Marca:" + this.getMarca() + "\n";
        String pPreco = " Preco    :" + this.getPreco() + "\n";
        String dados = pNome + pId + pMarca + pPreco + "\n";
        return dados;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Produto) {
            Produto oProduto = (Produto) o;
            return this.getId() == oProduto.getId();
        } else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.getId();
        return hash;
    }
}