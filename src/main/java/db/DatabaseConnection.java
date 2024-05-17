package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {
	  private static final String URL = "jdbc:mysql://localhost:3306/library";
	    private static final String USER = "root";
	    private static final String PASSWORD = "2311";
	    private static Connection connection;

	    static {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }

	    public static Connection getConnection() throws SQLException {
	        if (connection == null || connection.isClosed()) {
	            connection = DriverManager.getConnection(URL, USER, PASSWORD);
	        }
	        return connection;
	    }
}
