package cl.praxis.startup.connection;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class MySqlConnection {
    private static MySqlConnection instance;
    private Connection connection;
    private String jdbcURL ="jdbc:mysql://localhost:3306/demo_dao";
    private String jdbcUsername = "root";
    private String jdbcPassword = "DB14!";

    private MySqlConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException(e);
        }
    }

    public static MySqlConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new MySqlConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new MySqlConnection();
        }
        return instance;
    }
}
