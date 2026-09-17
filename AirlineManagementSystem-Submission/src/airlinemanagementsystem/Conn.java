package airlinemanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/** Creates JDBC connections using environment variables with local defaults. */
public class Conn implements AutoCloseable {
    private static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/airlinemanagementsystem?serverTimezone=UTC";
    private static final String DEFAULT_USER = "root";
    private static final String DEFAULT_PASSWORD = "";

    public final Connection c;
    public final Statement s;

    public Conn() throws SQLException {
        String url = envOrDefault("AIRLINE_DB_URL", DEFAULT_URL);
        String user = envOrDefault("AIRLINE_DB_USER", DEFAULT_USER);
        String password = envOrDefault("AIRLINE_DB_PASSWORD", DEFAULT_PASSWORD);
        c = DriverManager.getConnection(url, user, password);
        s = c.createStatement();
    }

    private static String envOrDefault(String key, String fallback) {
        String value = System.getenv(key);
        return value == null || value.isBlank() ? fallback : value;
    }

    @Override
    public void close() throws SQLException {
        c.close();
    }
}
