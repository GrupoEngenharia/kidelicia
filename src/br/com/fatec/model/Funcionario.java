package br.com.fatec.model;

/**
 *
 * @author matheus.marinelli
 */
public class Funcionario {
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private String login;
    private String senha;
    private String funcao;
    private String telefone;
    private String sexo;   
    private String rg;
    private String dataNasc;

    /**
     *
     * @param id
     * @param nome
     * @param email
     * @param cpf
     * @param login
     * @param senha
     * @param funcao
     * @param telefone
     * @param sexo
     * @param rg
     */
    public Funcionario(int id, String nome, String email, String cpf, String login, String senha, String funcao, String telefone, String sexo, String rg) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.funcao = funcao;
        this.telefone = telefone;
        this.sexo = sexo;
        this.rg = rg;
    }

    /**
     *
     */
    public Funcionario() {
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
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getCpf() {
        return cpf;
    }

    /**
     *
     * @param cpf
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     *
     * @return
     */
    public String getLogin() {
        return login;
    }

    /**
     *
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @return
     */
    public String getSenha() {
        return senha;
    }

    /**
     *
     * @param senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     *
     * @return
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     *
     * @param funcao
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    /**
     *
     * @return
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     *
     * @param telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     *
     * @return
     */
    public String getSexo() {
        return sexo;
    }

    /**
     *
     * @param sexo
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     *
     * @return
     */
    public String getRg() {
        return rg;
    }

    /**
     *
     * @param rg
     */
    public void setRg(String rg) {
        this.rg = rg;
    }   
    
}
