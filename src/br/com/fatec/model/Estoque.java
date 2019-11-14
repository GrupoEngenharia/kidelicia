package br.com.fatec.model;

public class Estoque {
    private int idEstoque;
    private Produto idProduto;
    private float preco;
    private int qtde;

    public Estoque() {
    }

    public Estoque(Produto p, float preco, int qtde) {
        this.preco = preco;
        this.qtde = qtde;
    }

    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
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
