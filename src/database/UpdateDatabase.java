package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDatabase {
    private static final String SELECTION_QUERY = "update users set ? = ? where ? = ?";

    public static void main(String[] args) {

    }
}
