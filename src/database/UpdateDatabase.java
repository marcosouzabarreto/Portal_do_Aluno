package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDatabase {
    private static final String SELECTION_QUERY = "update users set ? = ? where ? = ?";

    private String key;
    private String value;
    private String whereFirstArg;
    private String whereSecondArg;

    public UpdateDatabase(String key, String value, String whereFirstArg, String whereSecondArg){
        this.key = key;
        this.value = value;
        this.whereFirstArg = whereFirstArg;
        this.whereSecondArg = whereSecondArg;
    }

    public void updateRecord() throws SQLException {
        System.out.println(SELECTION_QUERY);
        try (Connection connection = DatabaseUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECTION_QUERY)) {

            preparedStatement.setString(1, this.key);
            preparedStatement.setString(2, this.value);
            preparedStatement.setString(3, this.whereFirstArg);
            preparedStatement.setString(4, this.whereSecondArg);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
}
