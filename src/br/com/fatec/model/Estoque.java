package br.com.fatec.model;

public class Estoque {
    private Produto p;
    private float preco;
    private int qtde;

    public Estoque() {
    }

    public Estoque(Produto p, float preco, int qtde) {
        this.p = p;
        this.preco = preco;
        this.qtde = qtde;
    }

    public Produto getP() {
        return p;
    }

    public void setP(Produto p) {
        this.p = p;
    }

    public float getPreco() {
        return preco * p.getPrecoUnitario() * 1.4f;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
            
    
            
    
    
}
