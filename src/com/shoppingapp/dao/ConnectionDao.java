package com.shoppingapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDao {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		String hostName="localhost";
		String dbName="Login";
		String userName="root";
		String password="admin";
		
		return getMySQLConnection(hostName, dbName, userName, password);
		
	}

	protected static Connection  getMySQLConnection(String hostName,String dbName, String userName,String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		  
	     String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
	  
	     Connection conn = DriverManager.getConnection(connectionURL, userName,
	             password);
	     return conn;

	}
	
	public static void getConnectionClose() {
		
	}

}
