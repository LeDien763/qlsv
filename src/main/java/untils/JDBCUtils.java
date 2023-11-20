package untils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {

	private static String jdbcURL = "jdbc:mysql://localhost:3306/quanlysinhvien";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "Hoang***1@";
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Updated driver class name for MySQL 8
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Connection error...");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection connection = JDBCUtils.getConnection();

        if (connection != null) {
            System.out.println("Connected to the database successfully!");
            // Perform additional testing or operations if needed
        } else {
            System.out.println("Failed to connect to the database.");
        }

        // Close the connection after testing
        JDBCUtils.closeConnection(connection);
    }
}
