package br.com.fatec.dao;

/**
 *
 * @author matheus.marinelli
 * @param <T>
 */
public interface DAO <T>{

    /**
     *
     * @param dado
     * @return
     */
    public boolean inserir(T dado);

    /**
     *
     * @param dado
     * @return
     */
    public boolean alterar(T dado);

    /**
     *
     * @param dado
     * @return
     */
    public boolean excluir(T dado);

    /**
     *
     * @param dado
     * @return
     */
    public T buscar(T dado);
    
}
