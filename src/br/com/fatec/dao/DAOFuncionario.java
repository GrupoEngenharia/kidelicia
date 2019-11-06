package br.com.fatec.dao;
import Database.Db;
import br.com.fatec.model.Funcionario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOFuncionario implements DAO{
    
    @Override
    public boolean inserir(Funcionario dado) {
    
        try {
            String querry = "INSERT into Funcionario (id, nome, email, cpf, login, senha, funcao, telefone, sexo, rg) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            Db.abreConexao();
                pst.setInt(1, dado.getId());
                pst.setString(2, dado.getNome());
                pst.setString(3, dado.getEmail());
                pst.setString(4, dado.getCpf());
                pst.setString(5, dado.getLogin());
                pst.setString(6, dado.getSenha());
                pst.setString(7, dado.getFuncao());
                pst.setString(8, dado.getTelefone());
                pst.setString(9, dado.getSexo());
                pst.setString(10, dado.getRg());
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
