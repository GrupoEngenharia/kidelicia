package br.com.fatec.model;

public class Produto {
    private int id;
    private String nomeProduto;
    private float precoUnitario;

    public Produto() {
    }

    public Produto(int id, String nomeProduto, float precoUnitario) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.precoUnitario = precoUnitario;
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

    public float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
    
    
    
    
}
