package com.bit.module01.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BitMysql {
	// 디자인패턴 - 싱글톤 패턴
	private static Connection conn=null;
	
	private BitMysql(){}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/scott";
		String user="user01";
		String password="1234";
		try {
			if(conn==null || conn.isClosed()) {
				Class.forName(driver);
				conn=DriverManager.getConnection(url, user, password);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
