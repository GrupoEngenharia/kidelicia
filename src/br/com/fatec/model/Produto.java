package br.com.fatec.model;

/**
 *
 * @author matheus.marinelli
 */
public class Produto {
    private int id;
    private String nomeProduto;
    private float precoUnitario;

    /**
     *
     */
    public Produto() {
    }

    /**
     *
     * @param id
     * @param nomeProduto
     * @param precoUnitario
     */
    public Produto(int id, String nomeProduto, float precoUnitario) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.precoUnitario = precoUnitario;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     *
     * @param nomeProduto
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     *
     * @return
     */
    public float getPrecoUnitario() {
        return precoUnitario;
    }

    /**
     *
     * @param precoUnitario
     */
    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
    
    
    
    
}
