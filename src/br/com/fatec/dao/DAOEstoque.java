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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CJ
 */
public class DAOEstoque implements DAO<Estoque> {

    /**
     *
     * @param dado
     * @return
     */
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
        } catch (SQLException | ClassNotFoundException ex) {
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

    /**
     *
     * @param dado
     * @return
     */
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
        } catch (SQLException | ClassNotFoundException ex) {
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

    /**
     *
     * @param dado
     * @return
     */
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
        } catch (SQLException | ClassNotFoundException ex) {
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

    //METODO RESOLVIDO

    /**
     *
     * @param dado
     * @return
     */
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
                dado.setProduto(produto);
                Db.fecharConexao();
                return dado;
            } else {
                dado = null;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DAOEstoque.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Db.fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(DAOEstoque.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dado;
    }

    //tela de reposição e controle estoque

    /**
     *
     * @param dado
     * @return
     */
    public Estoque BuscaProduto(Estoque dado) {//recebe String para pesquisa
        Estoque estoque = new Estoque();
        try {
            String querry = "select idProduto, qtdProduto from estoque where idProduto = ?;";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            DAOProduto daoProduto = new DAOProduto();//partiu outra dao...
            Produto produto = new Produto();
            produto = daoProduto.buscarNome(dado.getProduto());
            estoque.setProduto(produto);
            //estoque.setProduto(daoProduto.buscarNome(dado.getProduto()));//busca(e coloca no objeto estoque) um produto pesquisado
            pst.setInt(1, estoque.getProduto().getId());//caso seja encontrado um produto, coloca o id dele da querry
            ResultSet resp = pst.executeQuery();
            if (resp.next()) {
                estoque.setQtde(resp.getInt("qtdProduto"));//basicamente o que faltou colocar
                Db.fecharConexao();
                return estoque;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DAOEstoque.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Db.fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(DAOEstoque.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return estoque;
    }

    /**
     *
     * @return
     */
    public ArrayList<Estoque> BuscarTodos() {
        ArrayList<Estoque> EstoqueList = new ArrayList();
        try {
            String querry = "select idProduto,nomeProduto,precoUnitario from produto";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            ResultSet resp = pst.executeQuery();
            while (resp.next()) {
                Produto produto = new Produto();
                produto.setId(resp.getInt("idProduto"));
                produto.setNomeProduto(resp.getString("nomeProduto"));
                produto.setPrecoUnitario(resp.getFloat("precoUnitario"));
                querry = "SELECT * from estoque where idProduto = ?";
                pst = Db.conexao.prepareStatement(querry);
                pst.setInt(1, produto.getId());
                ResultSet r = pst.executeQuery();
                Estoque estoque = new Estoque();
                if (r.next()) {
                    estoque.setIdEstoque(r.getInt("idProduto"));
                    estoque.setQtde(r.getInt("qtdProduto"));
                    estoque.setProduto(produto);
                    EstoqueList.add(estoque);
                }
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Db.fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(DAOEstoque.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return EstoqueList;
    }
}
