package com.bit.framework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public 	class JdbcTemplate {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	DataSource dataSoruce;
	
	public JdbcTemplate() {
	}
	
	public JdbcTemplate(DataSource dataSoruce) throws SQLException {
		this.dataSoruce=dataSoruce;
	}
	
	public void setDataSoruce(DataSource dataSoruce) throws SQLException {
		this.dataSoruce = dataSoruce;
	}

	public int executeUpdate(String sql,Object[] objs) throws SQLException {
		try {
			conn=dataSoruce.getConnection();
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<objs.length; i++) {
				pstmt.setObject(1+i, objs[i]);
			}
			return pstmt.executeUpdate();
		}finally {
			close();
		}
	}
	
	public void close() throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
	
	public List queryForList(String sql,RowMapper mapper,Object[] objs) throws SQLException {
		List list=new ArrayList();
		Connection conn=dataSoruce.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<objs.length; i++)	pstmt.setObject(1+i, objs[i]);
			rs=pstmt.executeQuery();
			while(rs.next()) list.add(mapper.rows(rs));
		}finally {
			close();
		}
		return list;
	}
	

}
























