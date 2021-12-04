package database;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadDatabase {

    private static final String GET_ALL_STUDENTS_QUERY = "select id, name, email, subjects, function, passwd from users where function = ?";
    private static final String GET_USER_BY_NAME_QUERY = "select id, name, email, subjects, function, passwd from users where name = ?";
    private static final String GET_USER_BY_EMAIL_QUERY = "select id, name, email, subjects, function, passwd from users where email = ?";

    public User getUserByName(String name){
        return getUser(GET_USER_BY_NAME_QUERY, name);
    }

    public User getUserByEmail(String email){
        return getUser(GET_USER_BY_EMAIL_QUERY, email);
    }

    private User getUser(String getUserByEmailQuery, String arg) {
        User user = new User();
        try (Connection connection = DatabaseUtils.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(getUserByEmailQuery);) {
            preparedStatement.setString(1, arg);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                user.setId(id);
                String name = rs.getString("name");
                user.setName(name);
                String email = rs.getString("email");
                user.setEmail(email);
                String subjects = rs.getString("subjects");
                user.setSubjects(subjects);
                String function = rs.getString("function");
                user.setFunction(function);
                String passwd = rs.getString("passwd");
                user.setPasswd(passwd);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public DefaultListModel<User> getAllStudents() {

        DefaultListModel<User> students = new DefaultListModel<>();

        try (Connection connection = DatabaseUtils.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_STUDENTS_QUERY);) {
            preparedStatement.setString(1, "student");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();

                int id = rs.getInt("id");
                user.setId(id);
                String name = rs.getString("name");
                user.setName(name);
                String email = rs.getString("email");
                user.setEmail(email);
                String subjects = rs.getString("subjects");
                user.setSubjects(subjects);
                String function = rs.getString("function");
                user.setFunction(function);
                String passwd = rs.getString("passwd");
                user.setPasswd(passwd);

                students.addElement(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}