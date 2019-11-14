package br.com.fatec.model;

import java.util.LinkedList;

public class Comanda {
    private int idComanda;
    private Cliente cliente;
    private LinkedList<Produto> produtos;

    public int getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }

    public LinkedList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(LinkedList<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public Comanda() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public boolean contains(Produto produto){
        return produtos.contains(produto);
    }
    
    public void remover(Produto produto){
        if(this.contains(produto))
            produtos.remove(produto);
    }
    
    public void adicionar(Produto produto){
        produtos.add(produto);
    }
    
    public void removerQtd(Produto produto, int qtd){//remove as ocorrencias de produto na quantidade desejada
        for(int i=0; i<qtd; i++){
            if(produtos.remove(produto) == false)
                break;
        }
    }
    
    //se quiser alterar algo na lista deve-se remover antes
}
