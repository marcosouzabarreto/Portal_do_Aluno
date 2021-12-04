package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:h2:/home/marco/Documents/Programming/Faculdade/Portal_do_Aluno/src/database/portaldoaluno.db;MV_STORE=false","root","123456");
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}