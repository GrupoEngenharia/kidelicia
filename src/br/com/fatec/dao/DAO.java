package br.com.fatec.dao;

public interface DAO <T>{
    public boolean inserir(T dado);
    public boolean alterar(T dado);
    public boolean excluir(T dado);
    public T buscar(T dado);
    
}
