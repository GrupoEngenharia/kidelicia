/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.dao;

import Database.Db;
import br.com.fatec.model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class DAOProduto implements DAO<Produto> {

    @Override
    public boolean inserir(Produto dado) {
        try {
            String querry = "INSERT into Funcionario (nomeProduto, PrecoUnitario) values (?, ?);";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setString(2, dado.getNomeProduto());
            pst.setFloat(3, dado.getPrecoUnitario());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
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
    public boolean alterar(Produto dado) {
        try {
            String querry = "UPDATE produto set nomeProduto=?, PrecoUnitario=? where idproduto = ?;";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setString(1, dado.getNomeProduto());
            pst.setFloat(2, dado.getPrecoUnitario());
            pst.setInt(3, dado.getId());
            pst.execute();
            Db.fecharConexao();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
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
    public boolean excluir(Produto dado) {
        try {
            String querry = "DELETE from produto where idProduto = ?;";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setInt(1, dado.getId());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Db.fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public Produto buscar(Produto dado) {
        Produto produto = null;
        try {
            String querry = "SELECT * from Produto where id = ?;";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setInt(1, dado.getId());
            ResultSet resp = pst.executeQuery();
            if (resp.next()) {
                produto = new Produto();
                produto.setId(resp.getInt("idProduto"));
                produto.setNomeProduto(resp.getString("nome"));
                produto.setPrecoUnitario(resp.getFloat("Preco"));
                return produto;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Db.fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return produto;
    }
    
    public Produto buscarNome(Produto dado) {
        Produto produto = null;
        try {
            String querry = "SELECT * from Produto where nomeProduto = ?;";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setString(1, dado.getNomeProduto());
            ResultSet resp = pst.executeQuery();
            if (resp.next()) {
                produto = new Produto();
                produto.setId(resp.getInt("idProduto"));
                produto.setNomeProduto(resp.getString("nome"));
                produto.setPrecoUnitario(resp.getFloat("Preco"));
                return produto;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Db.fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return produto;
    }
}
