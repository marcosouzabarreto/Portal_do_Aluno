package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {

    private static final String createUsersTableSQL = "CREATE TABLE users (\r\n" +
            "  id INT auto_increment,\r\n" +
            "  name varchar(255),\r\n" +
            "  email varchar(255),\r\n" +
            "  subjects varchar(255),\r\n" +
            "  function varchar(255),\r\n" +
            "  passwd varchar(255)\r\n" + ");";

    public static void main(String[] args) throws SQLException {
        CreateDatabase createTableExample = new CreateDatabase();
        createTableExample.createTable();
    }

    public void createTable() throws SQLException {

        System.out.println(createUsersTableSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = DatabaseUtils.getConnection();
             // Step 2:Create a statement using connection object
             Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            statement.execute(createUsersTableSQL);

        } catch (SQLException e) {
            // print SQL exception information
            e.printStackTrace();
        }
    }
}