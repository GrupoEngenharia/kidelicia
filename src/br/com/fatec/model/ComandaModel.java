package br.com.fatec.model;

import java.util.LinkedList;

/**
 *
 * @author matheus.marinelli
 */
public class ComandaModel {
    private int idComanda;
    private Cliente cliente;
    private LinkedList<Produto> produtos;

    /**
     *
     * @param idComanda
     * @param cliente
     * @param produtos
     */
    public ComandaModel(int idComanda, Cliente cliente, LinkedList<Produto> produtos) {
        this.idComanda = idComanda;
        this.cliente = cliente;
        this.produtos = produtos;
    }
    
    /**
     *
     * @return
     */
    public int getIdComanda() {
        return idComanda;
    }

    /**
     *
     * @param idComanda
     */
    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }

    /**
     *
     * @return
     */
    public LinkedList<Produto> getProdutos() {
        return produtos;
    }

    /**
     *
     * @param produtos
     */
    public void setProdutos(LinkedList<Produto> produtos) {
        this.produtos = produtos;
    }
    
    /**
     *
     */
    public ComandaModel() {
    }

    /**
     *
     * @return
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     *
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    /**
     *
     * @param produto
     * @return
     */
    public boolean contains(Produto produto){
        return produtos.contains(produto);
    }
    
    /**
     *
     * @param produto
     */
    public void remover(Produto produto){
        if(this.contains(produto))
            produtos.remove(produto);
    }
    
    /**
     *
     * @param produto
     */
    public void adicionar(Produto produto){
        produtos.add(produto);
    }
    
    /**
     *
     * @param produto
     * @param qtd
     */
    public void removerQtd(Produto produto, int qtd){//remove as ocorrencias de produto na quantidade desejada
        for(int i=0; i<qtd; i++){
            if(produtos.remove(produto) == false)
                break;
        }
    }
    
    //se quiser alterar algo na lista deve-se remover antes
}
