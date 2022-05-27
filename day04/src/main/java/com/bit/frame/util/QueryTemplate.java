package com.bit.frame.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class QueryTemplate {
	Connection conn;
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public void close(Connection conn, PreparedStatement pstmt,ResultSet rs) throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
	
	public Object queryForObject(String sql) throws SQLException {
		return executeQuery(sql).get(0);
	}
	
	public List executeQuery(String sql) throws SQLException {
		List list=new ArrayList();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		////
		try {
			conn=this.getConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(rowMapper(rs));
			}
		}finally {
			close(conn,pstmt,rs);
		}
		return list;
	}
	public abstract Object rowMapper(ResultSet rs) throws SQLException;

}
