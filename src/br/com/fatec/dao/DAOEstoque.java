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
            String querry = "INSERT INTO Estoque (idProduto, qtdProduto) values (?, ?)";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setInt(1, dado.getProduto().getId());
            pst.setInt(2, dado.getQtde());
            pst.execute();
            Db.fecharConexao();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOEstoque.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOEstoque.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Db.fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(DAOEstoque.class.getName()).log(Level.SEVERE, null, ex);
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
            pst.setInt(1, dado.getProduto().getId());
            pst.setInt(2, dado.getQtde());
            pst.setInt(3, dado.getIdEstoque());
            pst.execute();
            Db.fecharConexao();
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
    public boolean excluir(Estoque dado) {//Exclui um produto da tabela estoque
        try {
            String querry = "DELETE from estoque where idProduto = ?;";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setInt(1, dado.getProduto().getId());
            pst.execute();
            Db.fecharConexao();
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
                Produto produto = new Produto();
                dado.setIdEstoque(resp.getInt("idEstoque"));
                DAOProduto daoProduto = new DAOProduto();
                produto = daoProduto.buscar(produto);
                dado.setQtde(resp.getInt("qtdProduto"));
                Db.fecharConexao();
                return dado;
            } else {
                dado = null;
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
        return dado;
    }
    
    //tela de reposição e controle estoque
    public Estoque oi(String dado){//recebe String para pesquisa
        Estoque estoque = null;
        try{
            String querry = "select idProduto, qtdProduto from estoque where idProduto = ?;";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            DAOProduto daoProduto = new DAOProduto();//partiu outra dao...
            estoque.setProduto(daoProduto.buscarNomev2(dado));//alterei a DAObusca para que recebesse string ao inves de produto
            pst.setInt(1, estoque.getProduto().getId());//pega o id do produto pesquisado
            ResultSet resp = pst.executeQuery();
            if (resp.next()){
                estoque.setQtde(resp.getInt("qtdProduto"));
                Db.fecharConexao();
                return estoque;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEstoque.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOEstoque.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Db.fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return estoque;
    }

}
