package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseProvider {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ecommerce";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Kevin@143";

    /**
     * Executes the provided SQL query and returns the results as a list of strings.
     * @param query The SQL query to execute
     * @return A list of strings representing the data fetched from the database
     */
    public static List<String> executeQuery(String query) {
        List<String> results = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()){
                results.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or log the exception as appropriate
        }
        return results;
    }

    /**
     * Convenience method to execute a SQL query and return the results as a list of strings.
     * @param query The SQL query to execute
     * @return A list of strings representing the data fetched from the database
     */
    public static List<String> getData(String query) {
        return executeQuery(query);
    }
}
