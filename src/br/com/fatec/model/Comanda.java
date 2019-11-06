package br.com.fatec.model;

import java.util.ArrayList;

public class Comanda {
    private ArrayList<Integer> comandas;

    public Comanda() {
    }

    public Comanda(ArrayList<Integer> comandas) {
        this.comandas = comandas;
    }

    public ArrayList<Integer> getComandas() {
        return comandas;
    }

    public void setComandas(ArrayList<Integer> comandas) {
        this.comandas = comandas;
    }
    
    

}
