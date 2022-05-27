package com.bit.frame.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bit.frame.model.entity.EmpVo;
import com.bit.frame.util.UpdateTemplate;

public class EmpDao {

	public List<EmpVo> selectAll() throws SQLException{
		String sql="select * from emp";
		return executeQuery(sql);
	}
	
	public List executeQuery(String sql) throws SQLException {
		List list=new ArrayList();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		////
		try {
			conn=getConnection();
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
	public Object rowMapper(ResultSet rs) throws SQLException {
		EmpVo bean=new EmpVo();
		bean.setEmpno(rs.getInt("empno"));
		bean.setEname(rs.getString("ename"));
		bean.setJob(rs.getString("job"));
		bean.setSal(rs.getInt("sal"));
		return bean;
	}

	public void insertOne(int empno, String ename, String job, int sal) throws SQLException {
		String sql="insert into emp (empno,ename,job,sal) values (?,?,?,?)";
		UpdateTemplate template = new UpdateTemplate() {

			@Override
			public void setStatement(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, empno);
				pstmt.setString(2, ename);
				pstmt.setString(3, job);
				pstmt.setInt(4, sal);
			}
		};
		template.setConn(getConnection());
		template.executeUpdate(sql);
		
	}

	public void deleteOne(int empno) throws SQLException {
		String sql="delete from emp where empno=?";
		UpdateTemplate template = new UpdateTemplate(getConnection()) {
				@Override
				public void setStatement(PreparedStatement pstmt) throws SQLException {
					pstmt.setInt(1, empno);
				}
		};
		template.executeUpdate(sql);
	}
	
	public Connection getConnection() throws SQLException {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/scott";
		String user="user01";
		String password="1234";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(url, user, password);
	}
	
	public void close(Connection conn, PreparedStatement pstmt,ResultSet rs) throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
}












