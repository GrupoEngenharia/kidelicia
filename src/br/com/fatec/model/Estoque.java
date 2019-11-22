package br.com.fatec.model;

/**
 *
 * @author matheus.marinelli
 */
public class Estoque {
    private int idEstoque;
    private Produto produto;
    private int qtde;

    /**
     *
     */
    public Estoque() {
    }

    /**
     *
     * @param idEstoque
     * @param produto
     * @param qtde
     */
    public Estoque(int idEstoque, Produto produto, int qtde) {
        this.idEstoque = idEstoque;
        this.produto = produto;
        this.qtde = qtde;
    }

    /**
     *
     * @return
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     *
     * @param produto
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     *
     * @return
     */
    public int getIdEstoque() {
        return idEstoque;
    }

    /**
     *
     * @param idEstoque
     */
    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }
    
    /**
     *
     * @return
     */
    public int getQtde() {
        return qtde;
    }

    /**
     *
     * @param qtde
     */
    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
            
    
            
    
    
}
