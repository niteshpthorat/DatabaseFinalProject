package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPostGres {
	public ConnectionPostGres() {
		super();
	}

	/**
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection c;
		String url = "jdbc:postgresql://cs1.calstatela.edu/";
		c = DriverManager.getConnection(url, "cs4222s64", "rbDmbj7L");
		return c;
	}
}
