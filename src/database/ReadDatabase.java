package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadDatabase {
    private static final String QUERY = "select id, name, email, subjects, function, passwd from users";

    public static void main(String[] args) {

        try (Connection connection = DatabaseUtils.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String subjects = rs.getString("subjects");
                String function = rs.getString("function");
                String passwd = rs.getString("passwd");
                System.out.println(id + "," + name + "," + email + "," + subjects + ","+ function + "," + passwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Step 4: try-with-resource statement will auto close the connection.
    }
}