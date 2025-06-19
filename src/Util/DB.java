package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}

	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	// private static Properties loadProperties() {
	// try (FileInputStream fs = new FileInputStream("db.properties")) {
	// Properties props = new Properties();
	// props.load(fs);
	// return props;
	// } catch (IOException e) {
	// throw new DbException(e.getMessage());
	// }
	// }

	private static Properties loadProperties() {
		Properties props = new Properties();
		try {
			// Carrega as variáveis do arquivo .env se ele existir
			File envFile = new File(".env");
			if (envFile.exists()) {
				props.load(new FileInputStream(envFile));
			}

			// Sobrescreve com variáveis de ambiente do sistema, se existirem
			// Isso dá prioridade às variáveis do sistema (útil em produção)
			String dbUser = System.getenv("DB_USER");
			String dbPassword = System.getenv("DB_PASSWORD");
			String dbUrl = System.getenv("DB_URL");

			if (dbUser != null)
				props.setProperty("user", dbUser);
			if (dbPassword != null)
				props.setProperty("password", dbPassword);
			if (dbUrl != null)
				props.setProperty("dburl", dbUrl);

			// Adiciona a propriedade useSSL que não é secreta
			props.setProperty("useSSL", "false");

			return props;

		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}

	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
