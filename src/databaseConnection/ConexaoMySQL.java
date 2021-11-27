package databaseConnection;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;


public class ConexaoMySQL {

        private static final String USUARIO = "root";
        private static final String SENHA = "";
        private static final String URL = "jdbc:mysql://127.0.0.1:3306/meubanco";
        private static final String DRIVER = "com.mysql.jdbc.Driver";

        // Conectar ao banco
        public static Connection abrir() throws Exception {
            // Registrar o driver
            Class.forName(DRIVER);
            // Capturar a conexão
            Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            // Retorna a conexao aberta
            return conn;
        }

    public static void getConexaoMySQL() {
            System.out.println("Foi conectado ao banco de dados");
    }

    public static boolean statusConection() {
        return false;
    }
}
