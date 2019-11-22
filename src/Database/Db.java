package Database;


import java.sql.*;

/**
 *
 * @author matheus.marinelli
 */
public class Db {

    /**
     * <b>Nome do servidor</b>
     */
    public static String servidor,

    /**
     * <b>Nome do DataBase utilizado</b>
     */
    nomeBanco,

    /**
     * <b>Nome de usuário para conexão com o DataBase</b>
     */
    usuario,

    /**
     *<b>Senha para conexão com o DataBase</b>
     */
    senha;

    /**
     * <b>Porta utilizada para conexão com o Database</b>
     */
    public static int porta;

    /**
     * <b>Objeto de conexão com o DataBase</b>
     */
    public static Connection conexao = null;
    /**
     * <i>Construtor estático usado para conectar com o DataBase</i>
     */
    static{
        servidor = "localhost";
        nomeBanco = "bd_lanchonete";
        usuario = "root";
        senha = "";
        porta = 3306;
    }
    
    /**
     * <b>Abre a conexão com o DataBase</b>
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void abreConexao() throws SQLException, ClassNotFoundException{
        String url = "jdbc:mysql://" + servidor + ":" + porta + "/" + nomeBanco;
        //Carrega o Driver
        Class.forName("com.mysql.jdbc.Driver");
        conexao = DriverManager.getConnection(url,usuario,senha);
    }
    
    /**
     * <b>Fecha a conexão com o DataBase</b>
     * @throws SQLException
     */
    public static void fecharConexao() throws SQLException{
        conexao.close();
    }
}
