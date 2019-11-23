/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.dao;

import Database.Db;
import br.com.fatec.model.ComandaModel;
import br.com.fatec.dao.DAOCliente;
import br.com.fatec.model.Cliente;
import br.com.fatec.model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CJ
 */
public class DAOComanda implements DAO<ComandaModel> {

    /**
     *
     * <b> Insere uma comanda no banco(idCliente e ID da Comanda) </b>
     */
    @Override
    public boolean inserir(ComandaModel dado) {
        try {
            String querry = "INSERT INTO Comanda (idCliente) values (?)";
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

    /**
     *
     * <b> altera um cliente no banco (status) </b>
     * @param dado
     * @return
     */
    @Override
    public boolean alterar(ComandaModel dado) {
        try {
            String querry = "UPDATE ComandaProduto set status=? where idComanda = ?";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setString(1, dado.getStatus());
            pst.setInt(2, dado.getIdComanda());
            pst.executeUpdate();
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

    /**
     *
     * <b> Deleta um cliente do banco </b>
     */
    @Override
    public boolean excluir(ComandaModel dado) {
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

    /**
     * <b> Busca uma comanda apartir do ID do cliente </b>
     */
    @Override
    public ComandaModel buscar(ComandaModel dado) {
        try {
            String querry = "SELECT * from comanda where idCliente = ?";
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

    /**
     *
     * <b> adiciona um pedido ma comanda do cliente </b>
     */
    public void ColocarProdutos(ComandaModel comanda) {
        try {
            LinkedList<Produto> produtos = comanda.getProdutos();
            Db.abreConexao();
            for (Produto produto : produtos) {
                String querry = "INSERT INTO ComandaProduto (idComanda, idProduto) values(?, ?)";
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

    /**
     *
     * <b> Busca um pedido(produto) em uma comanda </b>
     */
    public LinkedList<Produto> BuscarProdutos(int IdComanda) {

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

    /**
     *
     * <b> busca um pedido(produto em uma comanda, a quantidade pedida, e o status inicial </b>
     */
    public boolean InserirProduto(ComandaModel dado, Produto produto) {
        try {
            String querry = "INSERT INTO ComandaProduto (idComanda, idProduto, qtdProduto,status) values(?,?,?,?)";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setInt(1, dado.getIdComanda());
            pst.setInt(2, produto.getId());
            pst.setInt(3, dado.getQtd());
            pst.setString(4, "x");
            pst.execute();
            dado.adicionar(produto);
            return true;
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
        return false;
    }

    /**
     * 
     * <b> insere uma comanda no banco </b> 
     */
    public boolean inserirComandaCliente(ComandaModel dado) {
        try {
            String querry = "INSERT INTO Comanda values (?,?)";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setInt(1, dado.getIdComanda());
            pst.setInt(2, dado.getCliente().getIdCliente());
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

    /**
     * 
     * <b> exclui um pedido da comanda </b>
     */
    public boolean excluirProdutoComanda(ComandaModel dado, Produto produto) {
        String querry = "delete from bd_lanchonete.comandaproduto where idComanda = ? and idproduto = ? limit 1";
        try {
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setInt(1, dado.getIdComanda());
            pst.setInt(2, produto.getId());
            if (pst.executeUpdate() > 0) {
                Db.fecharConexao();
                return true;
            } else {
                Db.fecharConexao();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOComanda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOComanda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * 
     * <b> busca os dados de um pedido(ID, nome e status do produto) </b> 
     */
    public ComandaModel buscaComanda(ComandaModel comanda){
        LinkedList<Produto> produto = comanda.getProdutos();
        try{
        String querry = "SELECT * from comandaProduto where idComanda = ? and idProduto = ?";
        Db.abreConexao();
        PreparedStatement pst = Db.conexao.prepareStatement(querry);
        pst.setInt(1, comanda.getIdComanda());
        pst.setInt(2, produto.indexOf(0));
        ResultSet resp = pst.executeQuery();
        if(resp.next()){
            comanda.setIdComanda(resp.getInt("idComanda"));
            comanda.setStatus(resp.getString("status"));
        }
        Db.fecharConexao();
        return comanda;
        } catch (SQLException ex) {
            Logger.getLogger(DAOComanda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOComanda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comanda;
    }
    
    /**
     * 
     * <b> Busca todos os pedidos de todas as comandas </b>
     */
    public ArrayList<ComandaModel> buscaTodasComandas() {
        ArrayList<ComandaModel> comandas = new ArrayList();
        String querry = "Select idProduto, idComanda, status from ComandaProduto";
        try {
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            ResultSet resp = pst.executeQuery();
            while (resp.next()) {
                ComandaModel comanda = new ComandaModel();
                Produto produto = new Produto();
                DAOProduto daoProduto = new DAOProduto();
                LinkedList<Produto> produtos = new LinkedList();
                produto.setId(resp.getInt("idProduto"));//pega soment o ID do produto
                produto = daoProduto.buscar(produto);//busca o resto dos dados do produto(a partir do ID)
                produtos.add(produto);
                comanda.setProdutos(produtos);
                comanda.setIdComanda(resp.getInt("idComanda"));              
                comanda.setStatus(resp.getString("status"));
                comandas.add(comanda);
            }
            Db.fecharConexao();
            return comandas;
        } catch (SQLException ex) {
            Logger.getLogger(DAOComanda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOComanda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comandas;
    }
    
    /**
     * 
     * <b> altera o status do produto em uma comanda </b> 
     */
    public boolean alterarStatus(ComandaModel dado) {
        try {
            String querry = "UPDATE ComandaProduto set status=? where idComanda = ? and idProduto = ?";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            Produto produto = dado.getProdutos().get(0);
            pst.setString(1, dado.getStatus());
            pst.setInt(2, dado.getIdComanda());
            pst.setInt(3, produto.getId());
            pst.executeUpdate();
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
}
