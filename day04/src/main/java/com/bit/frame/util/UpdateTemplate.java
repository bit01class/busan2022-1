package com.bit.frame.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class UpdateTemplate {
	private Connection conn;
	
	public UpdateTemplate() {
	}
	public UpdateTemplate(Connection conn) {
		this.conn=conn;
	}
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public void executeUpdate(String sql) throws SQLException {
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		////
		try {
			pstmt=conn.prepareStatement(sql);
			setStatement(pstmt);
			pstmt.executeUpdate();
		}finally {
			close(conn,pstmt,null);
		}
	}
	// 
	public abstract void setStatement(PreparedStatement pstmt) throws SQLException;
	
	public void close(Connection conn, PreparedStatement pstmt,ResultSet rs) throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
}
