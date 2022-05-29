package jdbc.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionGet {
    public ConnectionGet() {
    }

    public static Connection getConnectionFor() throws SQLException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        String dbUrl = resourceBundle.getString("dbUrl");
        String dbUser = resourceBundle.getString("dbUser");
        String dbPass = resourceBundle.getString("dbPass");
        return DriverManager.getConnection(dbUrl, dbUser, dbPass);
    }
}
