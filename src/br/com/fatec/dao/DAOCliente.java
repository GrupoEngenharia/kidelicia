/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.dao;

import Database.Db;
import br.com.fatec.model.Cliente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class DAOCliente implements DAO<Cliente>{

    @Override
    public boolean inserir(Cliente dado) {
        try {
            String querry = "INSERT into Funcionario (idCliente, nome, telefone, email) values (?, ?, ?, ?);";
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            Db.abreConexao();
                pst.setInt(1, dado.getIdCliente());
                pst.setString(2, dado.getNome());
                pst.setString(3, dado.getTelefone());
                pst.setString(4, dado.getEmail());
                pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean alterar(Cliente dado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Cliente dado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente buscar(Cliente dado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
