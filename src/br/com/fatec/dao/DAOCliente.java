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
        try{
            String querry = "UPDATE cliente values(?, ?, ?) where idCliente = ?;";
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            Db.abreConexao();
            pst.setString(1, dado.getNome());
            pst.setString(2, dado.getTelefone());
            pst.setString(3, dado.getEmail());
            pst.setInt(4, dado.getIdCliente());
            pst.execute();
            Db.fecharConexao();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;      
    }

    @Override
    public boolean excluir(Cliente dado) {
        try{
            String quarry = "DELETE CLIENTE where idCliente = ?;";
            PreparedStatement pst = Db.conexao.prepareStatement(quarry);
            Db.abreConexao();
            pst.setInt(1, dado.getIdCliente());
            Db.fecharConexao();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Cliente buscar(Cliente dado) {
        try{
            String quarry = "Select * from Cliente whwre idCliente = ?;";
            PreparedStatement pst = Db.conexao.prepareStatement(quarry);
            Db.abreConexao();
            pst.setInt(1, dado.getIdCliente());
            ResultSet resp = pst.executeQuery();
            if(resp.next()){
                Cliente cliente = new Cliente();
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
        return null;
    }

    
}
