package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertIntoDatabase {
    private static final String INSERT_USERS_SQL = "INSERT INTO users" +
            "  (name, email,subjects, function, passwd) VALUES " +
            " (?, ?, ?, ?, ?);";

    public static void main(String[] args) throws SQLException {
        InsertIntoDatabase createTableExample = new InsertIntoDatabase();
        createTableExample.insertRecord();
    }

    public void insertRecord() throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // Step 1: Establishing a Connection
        try (Connection connection = DatabaseUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, "Marco Barreto");
            preparedStatement.setString(2, "marcobarreto@gmail.com");
            preparedStatement.setString(3, "Matemática");
            preparedStatement.setString(4, "admin");
            preparedStatement.setString(5, "123456");

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            e.printStackTrace();
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }
}