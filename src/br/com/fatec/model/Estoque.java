package br.com.fatec.model;

public class Estoque {
    private int idEstoque;
    private Produto produto;
    private int qtde;

    public Estoque() {
    }

    public Estoque(int idEstoque, Produto produto, int qtde) {
        this.idEstoque = idEstoque;
        this.produto = produto;
        this.qtde = qtde;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }
    
    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
            
    
            
    
    
}
