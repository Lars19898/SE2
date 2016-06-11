package com.example.services.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCConnection {
	private static JDBCConnection connection = null;
	private String url = "jdbc:mysql://localhost:3306/myhotelapp";
	private String login = "root";
	private String password = "admin";
	private Connection con;
	private PreparedStatement st;

	public static JDBCConnection getinstance() {

		if (connection == null) {
			connection = new JDBCConnection();
		}
		return connection;
	}

	private JDBCConnection() {
		this.initconnection();
	}

	public void initconnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.openConnection();
	}

	public void openConnection() {
		Properties prop = new Properties();
		prop.setProperty("user", this.login);
		prop.setProperty("password", this.password);

		try {
			this.con = DriverManager.getConnection(this.url, prop);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}  
	
	public void closeConnection(){
		connection.closeConnection();
	}

	public PreparedStatement getLoginStatement(String sql) {

		try {
			st = con.prepareStatement(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;

	}

}
