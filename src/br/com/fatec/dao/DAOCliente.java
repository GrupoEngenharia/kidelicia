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

    /**
     *
     * <b> Insere um cliente no banco com os valores (nome, telefone e email) </b>
     */
    @Override
    public boolean inserir(Cliente dado) {
        try {
            String querry = "INSERT into Cliente (nome, telefone, email) values (?, ?, ?)";
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

    /**
     *
     * <b> Altera no banco nome e telefone tendo como pararametro de busca o email </b>
     */
    @Override
    public boolean alterar(Cliente dado) {
        try {
            String querry = "UPDATE cliente set nome=?, telefone=? where email = ?";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setString(1, dado.getNome());
            pst.setString(2, dado.getTelefone());
            pst.setString(3, dado.getEmail());
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

    /**
     *
     * <b> Exclui um cliente do banco, busca pelo ID </b>
     * @return retorna true se o cliente foi excluído
     */
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

    /**
     *
     * <b> busca todos os dados de um cliente do banco, buscando pelo ID </b>
     */
    @Override
    public Cliente buscar(Cliente dado) {
        Cliente cliente = null;
        try {
            String quarry = "Select * from Cliente where email = ?";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(quarry);
            pst.setString(1, dado.getEmail());
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
