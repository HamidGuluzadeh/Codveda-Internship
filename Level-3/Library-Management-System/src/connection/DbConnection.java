package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String url = "jdbc:mysql://localhost:3306/library_db";
    private static final String username = "root";
    private static final String password = "admin";

    public static Connection getConnection() {
        Connection connection;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
            System.out.println("Successfully connected!");
        } catch (ClassNotFoundException | SQLException exception) {
            throw new RuntimeException(exception);
        }

        return connection;
    }
}
