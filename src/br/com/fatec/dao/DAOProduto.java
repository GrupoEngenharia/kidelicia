/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.dao;

import Database.Db;
import br.com.fatec.model.Produto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
    public class DAOProduto implements DAO{

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
                Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }

    @Override
    public boolean alterar(Object dado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Object dado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscar(Object dado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
