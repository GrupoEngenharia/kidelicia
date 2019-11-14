package br.com.fatec.model;

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

    public Funcionario() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }   
    
}
