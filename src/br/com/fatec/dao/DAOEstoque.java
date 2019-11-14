/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.dao;

import Database.Db;
import br.com.fatec.model.Estoque;
import br.com.fatec.model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CJ
 */
public class DAOEstoque implements DAO<Estoque> {

    @Override
    public boolean inserir(Estoque dado) {
        try {
            String querry = "INSERT INTO Estoque (idProduto, qtdProduto) values (?, ?);";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            Produto produto = new Produto();
            pst.setInt(1, produto.getId());
            pst.setInt(2, dado.getQtde());
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
    public boolean alterar(Estoque dado) {
        try {
            String querry = "UPDATE from estoque values(?, ?) where id = ?;";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            Produto produto = new Produto();
            pst.setInt(1, produto.getId());
            pst.setInt(2, dado.getQtde());
            pst.setInt(3, dado.getIdEstoque());
            //pst.setInt(4, );
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
    public boolean excluir(Estoque dado) {
        try {
            String querry = "DELETE from estoque where id = ?;";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            //pst.setInt(1, );
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

    //METODO RESOLVIDO
    @Override
    public Estoque buscar(Estoque dado) {
        try {
            String querry = "Select * from estoque where idEstoque = ?;";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setInt(1, dado.getIdEstoque());
            ResultSet resp = pst.executeQuery();
            if (resp.next()) {
                Estoque estoque = new Estoque();
                dado.setIdEstoque(resp.getInt("idEstoque"));
                Produto produto = new Produto();
		produto.setId(resp.getInt("idProduto"));
		DAOProduto dao = new DAOProduto();
		dado.setIdProduto(dao.buscar(produto));
		dado.setQtde(resp.getInt("qtdProduto"));
                return estoque;
            }
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
        return null;
    }

}
