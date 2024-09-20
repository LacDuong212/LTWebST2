package LD01.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionSQL {
	private final String serverName = "LDUONG";
	private final String dbName = "ltwebst2";
	private final String portnumber = "1433";
	private final String instance = "";
	// empty if there is only one instance of SQL Server
	private final String username = "sa";
	private final String password = "123";

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		String url = "jdbc:sqlserver://" + serverName + ":" + portnumber + "\\" + instance + ";databaseName=" + dbName;

		if (instance == null || instance.trim().isEmpty())

			url = "jdbc:sqlserver://" + serverName + ":" + portnumber + ";databaseName=" + dbName;

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		return DriverManager.getConnection(url, username, password);
	}

	// test run: right click -> Run as -> Java application
	public static void main(String[] args) {
		try {

			System.out.println(new DBConnectionSQL().getConnection());

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
