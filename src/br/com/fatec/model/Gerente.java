/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.model;

/**
 *
 * @author aluno
 */
public class Gerente extends Funcionario{

    public Gerente() {
    }

    public Gerente(String nome, String email, String cpf, String funcao, String telefone, String sexo) {
        super(nome, email, cpf, funcao, telefone, sexo);
    }
    
}
