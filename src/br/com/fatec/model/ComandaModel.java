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
    private int qtd;
    private String status;

    /**
     * <b>Instancia uma comanda com todos os parâmetros</b>
     * @param idComanda
     * @param cliente
     * @param produtos
     */
    public ComandaModel(int idComanda, Cliente cliente, LinkedList<Produto> produtos) {
        this.idComanda = idComanda;
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
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
     * <b>Verifica se a comanda possui um produto</b>
     * @param produto
     * @return
     */
    public boolean contains(Produto produto){
        return produtos.contains(produto);
    }
    
    /**
     * <b>Remove um produto da comanda</b>
     * @param produto
     */
    public void remover(Produto produto){
        if(this.contains(produto))
            produtos.remove(produto);
    }
    
    /**
     *<b>Remove um produto da comanda</b>
     * @param produto
     */
    public void adicionar(Produto produto){
        produtos.add(produto);
    }
    
    /**
     * <b>Remove a quantidade desejada de um produto</b>
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
