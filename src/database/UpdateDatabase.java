package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDatabase {
    private static final String SELECTION_QUERY = "update users set subjects = ? where name = ?;";


    public void updateRecord(String subjects, String name) throws SQLException {
        System.out.println(SELECTION_QUERY);
        try (Connection connection = DatabaseUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECTION_QUERY)) {

            System.out.println(subjects);
            preparedStatement.setString(1, subjects);
            preparedStatement.setString(2, name);


            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
}
