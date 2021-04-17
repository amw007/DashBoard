package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:mariadb://cloud2.zolahost.net/goldenpr_eceianstech","goldenpr_eceianstech","Admin1q2w@");
        return connection;
    }
}
