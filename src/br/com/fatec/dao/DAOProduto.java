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
    public class DAOProduto implements DAO<Produto>{

        @Override
         public boolean inserir(Produto dado) {
            try {
                String querry = "INSERT into Funcionario (id, nomeProduto, PrecoUnitario) values (?, ?, ?);";
                    PreparedStatement pst = Db.conexao.prepareStatement(querry);
                    Db.abreConexao();
                    pst.setInt(1, dado.getId());
                    pst.setString(2, dado.getNomeProduto());
                    pst.setFloat(3, dado.getPrecoUnitario());
                    pst.executeUpdate();
                    return true;
            } catch (SQLException ex) {
                Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }

        @Override
        public boolean alterar(Produto dado) {
            try{
                String querry = "UPDATE from produto values(?, ?) where id = ?;";
                PreparedStatement pst = Db.conexao.prepareStatement(querry);
                Db.abreConexao();
                pst.setString(1, dado.getNomeProduto());
                pst.setFloat(2, dado.getPrecoUnitario());
                pst.setInt(4, dado.getId());
                pst.execute();
                Db.fecharConexao();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }

        @Override
        public boolean excluir(Produto dado) {
            try{
                String querry = "DELETE from produto where id = ?;";
                PreparedStatement pst = Db.conexao.prepareStatement(querry);
                Db.abreConexao();
                pst.setInt(1, dado.getId());
                pst.execute();
                Db.fecharConexao();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }

        @Override
        public Produto buscar(Produto dado) {
            try{
                String querry = "SELECT * from Produto where id = ?;";
                PreparedStatement pst = Db.conexao.prepareStatement(querry);
                pst.setInt(1, dado.getId());
                ResultSet resp = pst.executeQuery();
                if(resp.next()){
                    Produto produto = new Produto();
                    produto.setNomeProduto(resp.getString("nome"));
                    produto.setPrecoUnitario(resp.getFloat("Preco"));
                    return produto;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }


