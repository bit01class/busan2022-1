package com.bit.frame.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bit.frame.model.entity.EmpVo;

public class EmpDao {

	public List<EmpVo> selectAll() throws SQLException{
		List<EmpVo> list=new ArrayList<>();
		String sql="select * from emp";
		////
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/scott";
		String user="user01";
		String password="1234";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		////
		try {
			conn=DriverManager.getConnection(url, user, password);
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				EmpVo bean=new EmpVo();
				bean.setEmpno(rs.getInt("empno"));
				bean.setEname(rs.getString("ename"));
				bean.setJob(rs.getString("job"));
				bean.setSal(rs.getInt("sal"));
				list.add(bean);
			}
		}finally {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		
		return list;
	}

	public void insertOne(int empno, String ename, String job, int sal) throws SQLException {
		String sql="insert into emp (empno,ename,job,sal) values (?,?,?,?)";
		////
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/scott";
		String user="user01";
		String password="1234";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		////
		try {
			conn=DriverManager.getConnection(url, user, password);
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			pstmt.setString(2, ename);
			pstmt.setString(3, job);
			pstmt.setInt(4, sal);
			pstmt.executeUpdate();
		}finally {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}		
		
	}
}












