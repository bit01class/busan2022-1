package com.bit.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bit.util.Mysql;

public class LoginDao {

	public boolean loginResult(int empno,String ename) {
		String sql="select count(*) from emp where empno=? and ename=?";
		try(
				Connection conn=Mysql.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
		){
			pstmt.setInt(1, empno);
			pstmt.setString(2, ename);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
				return rs.getInt(1)>0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
