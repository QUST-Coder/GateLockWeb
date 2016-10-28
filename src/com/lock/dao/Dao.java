package com.lock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
	private String urlString = "jdbc:mysql://localhost:3306/regist";
	private String nameString = "root";
	private String passwordString = "123456";
	Connection conn= null;
	Statement statement = null;
	ResultSet rs = null;

	public ResultSet selectDate(String sql) throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(urlString,nameString, passwordString);
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			return rs;
	}
	
	public int insertDate(String sql) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(urlString,nameString, passwordString);
		statement = conn.createStatement();
		int re = statement.executeUpdate(sql);
		return re;
}
	
	
	public void closeAll(){
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
}
