package br.com.fatec.model;

public class Garcom extends Funcionario{

    public Garcom() {
    }

    public Garcom(int id, String nome, String email, String cpf, String login, String senha, String funcao, String telefone, String sexo, String rg) {
        super(id, nome, email, cpf, login, senha, funcao, telefone, sexo, rg);
    }

}
