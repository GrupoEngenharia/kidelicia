package br.com.fatec.dao;

import Database.Db;
import br.com.fatec.model.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOFuncionario implements DAO<Funcionario> {

    @Override
    public boolean inserir(Funcionario dado) {

        try {
            String querry = "INSERT into Funcionario (nome, email, cpf, login, senha, funcao, telefone, sexo, rg) values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            //Não se colca idFuncionario pois no banco esta auto_increment
            pst.setString(1, dado.getNome());
            pst.setString(2, dado.getEmail());
            pst.setString(3, dado.getCpf());
            pst.setString(4, dado.getLogin());
            pst.setString(5, dado.getSenha());
            pst.setString(6, dado.getFuncao());
            pst.setString(7, dado.getTelefone());
            pst.setString(8, dado.getSexo());
            pst.setString(9, dado.getRg());
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

    @Override
    public boolean alterar(Funcionario dado) {
        try {
            String querry = "UPDATE from funcionario values(?, ?, ?, ?, ?, ?, ?, ?, ?) where idFuncionario = ?;";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setString(1, dado.getNome());
            pst.setString(2, dado.getEmail());
            pst.setString(3, dado.getCpf());
            pst.setString(4, dado.getLogin());
            pst.setString(5, dado.getSenha());
            pst.setString(6, dado.getFuncao());
            pst.setString(7, dado.getTelefone());
            pst.setString(8, dado.getSexo());
            pst.setString(9, dado.getRg());
            pst.setInt(10, dado.getId());
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
    public boolean excluir(Funcionario dado) {
        try {
            String querry = "DELETE from Funcionario where idFuncionario = ?;";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setInt(1, dado.getId());
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
    public Funcionario buscar(Funcionario dado) {
        Funcionario funcionario = null;
        try {
            String querry = "SELECT * from funcionario where idFuncionario = ?;";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setInt(1, dado.getId());
            ResultSet resp = pst.executeQuery();
            if (resp.next()) {
                funcionario = new Funcionario();
                funcionario.setId(resp.getInt("idfuncionario"));
                funcionario.setNome(resp.getString("nome"));
                funcionario.setEmail(resp.getString("email"));
                funcionario.setCpf(resp.getString("cpf"));
                funcionario.setLogin(resp.getString("login"));
                funcionario.setSenha(resp.getString("senha"));
                funcionario.setFuncao(resp.getString("funcao"));
                funcionario.setTelefone(resp.getString("telefone"));
                funcionario.setSexo(resp.getString("sexo"));
                funcionario.setRg(resp.getString("rg"));
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
        return funcionario;
    }

    public Funcionario buscarFuncao(Funcionario dado) {
        Funcionario funcionario = null;
        try {
            String querry = "SELECT * from funcionario where funcao = ?;";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setString(1, dado.getFuncao());
            ResultSet resp = pst.executeQuery();
            if (resp.next()) {
                funcionario = new Funcionario();
                funcionario.setId(resp.getInt("idfuncionario"));
                funcionario.setNome(resp.getString("nome"));
                funcionario.setEmail(resp.getString("email"));
                funcionario.setCpf(resp.getString("cpf"));
                funcionario.setLogin(resp.getString("login"));
                funcionario.setSenha(resp.getString("senha"));
                funcionario.setFuncao(resp.getString("funcao"));
                funcionario.setTelefone(resp.getString("telefone"));
                funcionario.setSexo(resp.getString("sexo"));
                funcionario.setRg(resp.getString("rg"));
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
        return funcionario;
    }

    public Funcionario buscarCpf(Funcionario dado) {
        Funcionario funcionario = null;
        try {
            String querry = "SELECT * from funcionario where cpf = ?;";
            Db.abreConexao();
            PreparedStatement pst = Db.conexao.prepareStatement(querry);
            pst.setString(1, dado.getCpf());
            ResultSet resp = pst.executeQuery();
            if (resp.next()) {
                funcionario = new Funcionario();
                funcionario.setId(resp.getInt("idfuncionario"));
                funcionario.setNome(resp.getString("nome"));
                funcionario.setEmail(resp.getString("email"));
                funcionario.setCpf(resp.getString("cpf"));
                funcionario.setLogin(resp.getString("login"));
                funcionario.setSenha(resp.getString("senha"));
                funcionario.setFuncao(resp.getString("funcao"));
                funcionario.setTelefone(resp.getString("telefone"));
                funcionario.setSexo(resp.getString("sexo"));
                funcionario.setRg(resp.getString("rg"));
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
        return funcionario;
    }
}
