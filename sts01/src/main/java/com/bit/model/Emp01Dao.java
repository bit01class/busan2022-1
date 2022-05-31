package com.bit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Emp01Dao {
	
	public List<EmpVo> selectAll() throws ClassNotFoundException, SQLException{
		List<EmpVo> list=new ArrayList<>();
		String sql="select * from emp";
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/scott";
		String user="user01";
		String password="1234";
		
		Class.forName(driver);
		try(
				Connection conn=DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt=conn.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();
				){
			while(rs.next())list.add(new EmpVo(
					rs.getInt("empno"),rs.getString("ename")
					,rs.getInt("sal"),rs.getString("job")
					));
		}
		return list;
	}

	public void insertOne(EmpVo bean) throws ClassNotFoundException, SQLException {
		String sql="insert into emp (empno,ename,sal,job) values (?,?,?,?)";
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/scott";
		String user="user01";
		String password="1234";
		
		Class.forName(driver);
		try(
				Connection conn=DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setInt(1, bean.getEmpno());
			pstmt.setString(2, bean.getEname());
			pstmt.setInt(3, bean.getSal());
			pstmt.setString(4, bean.getJob());
			pstmt.executeUpdate();
		}
		
	}
}
