package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionProvider {
	private static Connection conn;

	static {
		Properties properties = null;

		try {
			properties = Resource.getProperties("/database.properties");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String userpassword = properties.getProperty("password");
			conn = (Connection) DriverManager.getConnection(url, username, userpassword);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static Connection getConnection() {
		return conn;
	}

	public static void close() {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
