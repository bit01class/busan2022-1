package com.bit.emp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
	Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public EmpDao(){
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/scott";
		String user="user01";
		String password="1234";
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<EmpVo> selectAll() throws SQLException {
		List<EmpVo> list=new ArrayList<>();
		String sql="select * from emp";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) list.add(new EmpVo(
					rs.getInt("empno"),rs.getInt("sal"),rs.getString("ename"),rs.getString("job")
					));
		}finally {
			
		}
		return list;
	}

}
