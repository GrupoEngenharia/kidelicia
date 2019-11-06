package br.com.fatec.model;

import java.util.ArrayList;

public class Venda {
    private Comanda ccomanda;
    private Cliente cliente;
    private ArrayList<Produto> produtos;

    public Venda() {
    }

    public Venda(Comanda ccomanda, Cliente cliente, ArrayList<Produto> produtos) {
        this.ccomanda = ccomanda;
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public Comanda getCcomanda() {
        return ccomanda;
    }

    public void setCcomanda(Comanda ccomanda) {
        this.ccomanda = ccomanda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
    
    
}
