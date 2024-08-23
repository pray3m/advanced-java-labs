import com.codewithprem.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class DbConnectionTest {
    public static void main(String[] args) {
        // Obtain a connection using the Singleton
        Connection connection = DbConnection.getConnection();

        // Check if the connection is not null
        if (connection != null) {
            System.out.println("Database connection established successfully!");

            try {
                // Test the connection
                if (!connection.isClosed()) {
                    System.out.println("Connection is open.");
                } else {
                    System.out.println("Connection is closed.");
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Handle exception
            }
        } else {
            System.out.println("Failed to establish a database connection.");
        }
    }
}
