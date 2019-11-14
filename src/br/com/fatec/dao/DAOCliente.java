/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.dao;

import Database.Db;
import br.com.fatec.model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class DAOCliente implements DAO<Cliente> {

    @Override
    public boolean inserir(Cliente dado) {
        try {
            String querry = "INSERT into Funcionario (nome, telefone, email) values (?, ?, ?);";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setString(1, dado.getNome());
            pst.setString(2, dado.getTelefone());
            pst.setString(3, dado.getEmail());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Db.fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean alterar(Cliente dado) {
        try {
            String querry = "UPDATE cliente set nome=?, telefone=?, email=? where idCliente = ?;";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setString(1, dado.getNome());
            pst.setString(2, dado.getTelefone());
            pst.setString(3, dado.getEmail());
            pst.setInt(4, dado.getIdCliente());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Db.fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean excluir(Cliente dado) {
        try {
            String quarry = "DELETE CLIENTE where idCliente = ?;";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(quarry);
            pst.setInt(1, dado.getIdCliente());
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Db.fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public Cliente buscar(Cliente dado) {
        Cliente cliente = null;
        try {
            String quarry = "Select * from Cliente whwre idCliente = ?;";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(quarry);
            pst.setInt(1, dado.getIdCliente());
            ResultSet resp = pst.executeQuery();
            if (resp.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(resp.getInt("idCliente"));
                cliente.setNome(resp.getString("Nome"));
                cliente.setTelefone(resp.getString("Telefone"));
                cliente.setEmail(resp.getString("Email"));
                return cliente;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

}
