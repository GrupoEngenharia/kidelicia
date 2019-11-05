package br.com.fatec.model;

public abstract class Funcionario {
    //private int id;
    private String nome;
    private String email;
    private String cpf;
    //private String login;
    //private String senha;
    private String funcao;
    private String telefone;
    private String sexo;

    public Funcionario() {
    }

    public Funcionario(String nome, String email, String cpf, String funcao, String telefone, String sexo) {
        //this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        //this.login = login;
        //this.senha = senha;
        this.funcao = funcao;
        this.telefone = telefone;
        this.sexo = sexo;
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
    
    
    
    
    
}
