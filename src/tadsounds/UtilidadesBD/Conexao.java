package tadsounds.UtilidadesBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//classe que permite a conexao com o banco de dados
public class Conexao {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/tadSounds";
    private static final String USER = "root";
    private static final String PASS = "adminadmin";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Erro na conexão com o banco de dados", ex);
        }
    }
}
