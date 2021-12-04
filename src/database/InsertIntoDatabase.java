package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertIntoDatabase {
    private final String name;
    private final String email;
    private final String subjects;
    private final String function;
    private final String passwd;

    private static final String INSERT_USERS_SQL = "INSERT INTO users" +
            " (name, email,subjects, function, passwd) VALUES " +
            " (?, ?, ?, ?, ?);";

    public InsertIntoDatabase(String name, String email, String subjects, String function,String passwd){
        this.name = name;
        this.email = email ;
        this.subjects = subjects;
        this.function = function;
        this.passwd = passwd;
    }

    public void insertRecord() throws SQLException {
        System.out.println(INSERT_USERS_SQL);

        try (Connection connection = DatabaseUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, this.name);
            preparedStatement.setString(2, this.email);
            preparedStatement.setString(3, this.subjects);
            preparedStatement.setString(4, this.function);
            preparedStatement.setString(5, this.passwd);

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
}