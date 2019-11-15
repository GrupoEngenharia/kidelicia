/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.dao;

import Database.Db;
import br.com.fatec.model.Comanda;
import br.com.fatec.dao.DAOCliente;
import br.com.fatec.model.Cliente;
import br.com.fatec.model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CJ
 */
public class DAOComanda implements DAO<Comanda> {

    @Override
    public boolean inserir(Comanda dado) { 
        try {
            String querry = "INSERT INTO Comanda (idCliente) values (?) where idComanda = ?;";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setInt(1, dado.getCliente().getIdCliente());
            pst.setInt(2, dado.getIdComanda());
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
                Logger.getLogger(DAOComanda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean alterar(Comanda dado) {
        try {
            String querry = "UPDATE from ComandaProduto where idComanda = ?";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setInt(1, dado.getIdComanda());
            pst.execute();
            inserir(dado);
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
                Logger.getLogger(DAOComanda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean excluir(Comanda dado) {
        boolean resp = false;
        try {
            String querry = "DELETE from ComandaProduto where idComanda = ?";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setInt(1, dado.getIdComanda());
            pst.execute();
            querry = "DELETE from Comanda where idComanda = ?";
            pst = Db.conexao.prepareStatement(querry);
            pst.setInt(1, dado.getIdComanda());
            pst.execute();
            dado = buscar(dado);
            if (dado == null) {
                resp = true;
            }
        } catch (SQLException | ClassNotFoundException e) {
        } finally {
            try {
                Db.fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(DAOComanda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public Comanda buscar(Comanda dado) {
        try {
            String querry = "SELECT * from comanda where idCliente = ?;";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setInt(1, dado.getCliente().getIdCliente());
            ResultSet resp = pst.executeQuery();
            if (resp.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resp.getInt("idCliente"));
                DAOCliente dao = new DAOCliente();
                cliente = dao.buscar(cliente);
                dado.setCliente(cliente);
                dado.setProdutos(BuscarProdutos(dado.getIdComanda()));
            } else {
                dado = null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOComanda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOComanda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Db.fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(DAOComanda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dado;
    }

    private void ColocarProdutos(Comanda comanda) {
        try {
            LinkedList<Produto> produtos = comanda.getProdutos();
            Db.abreConexao();
            for (Produto produto : produtos) {
                String querry = "INSERT INTO ComandaProduto (idComanda, idProduto) values(?, ?);";
                PreparedStatement pst = Db.conexao.prepareStatement(querry);
                pst.setInt(1, comanda.getIdComanda());
                pst.setInt(2, produto.getId());
                pst.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOComanda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOComanda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Db.fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(DAOComanda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private LinkedList<Produto> BuscarProdutos(int IdComanda) {

        LinkedList<Produto> list = new LinkedList();
        try {
            String quarry = "Select idProduto from ComandaProduto where idComanda = ?";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(quarry);
            pst.setInt(1, IdComanda);
            ResultSet resp = pst.executeQuery();
            DAOProduto dao = new DAOProduto();
            while (resp.next()) {
                Produto produto = new Produto();
                produto.setId(resp.getInt("idProduto"));
                produto = dao.buscar(produto);
                list.add(produto);
            }
        } catch (Exception ex) {

        } finally {
            try {
                Db.fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(DAOComanda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
    public Comanda InserirProduto(Comanda dado, Produto produto){
        try{
            String querry = "INSERT from ComandaProduto(?) where idComanda = ?";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setInt(1, produto.getId());
            pst.setInt(2, dado.getIdComanda());
            pst.execute();
            dado.adicionar(produto);
        } catch (SQLException ex) {
            Logger.getLogger(DAOComanda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOComanda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Db.fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(DAOComanda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dado;
    }
}
