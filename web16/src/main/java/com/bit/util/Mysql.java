package com.bit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class Mysql {
	private static Logger log=Logger.getLogger(Mysql.class);
	private static Connection conn;
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/scott";
	private static final String user="user01";
	private static final String password="1234";
	
	private Mysql() {}
	
	public static Connection getConnection() throws SQLException {
		
		if(conn==null || (conn!=null && conn.isClosed())) {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				log.error("드라이버 확인...");
			}
			conn=DriverManager.getConnection(url, user, password);
		}
		return conn;
	}
}
