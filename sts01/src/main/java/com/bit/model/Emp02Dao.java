package com.bit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Emp02Dao implements EmpDao{
	DataSource dataSource;
	
	public Emp02Dao() {
		String url="jdbc:mysql://localhost:3306/scott";
		String user="user01";
		String password="1234";
		MysqlDataSource dataSource=new MysqlDataSource();
		dataSource.setUrl(url);
		dataSource.setUser(user);
		dataSource.setPassword(password);
		this.dataSource=dataSource;
	}
	
	public List<EmpVo> selectAll() throws SQLException{
		List<EmpVo> list=new ArrayList<>();
		String sql="select * from emp";
		try(
				Connection conn=dataSource.getConnection();
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

	public void insertOne(EmpVo bean) throws SQLException {
		String sql="insert into emp (empno,ename,sal,job) values (?,?,?,?)";
		try(
				Connection conn=dataSource.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setInt(1, bean.getEmpno());
			pstmt.setString(2, bean.getEname());
			pstmt.setInt(3, bean.getSal());
			pstmt.setString(4, bean.getJob());
			pstmt.executeUpdate();
		}
		
	}

	public EmpVo selectOne(int parseInt) throws SQLException {
		String sql="select * from emp where empno=?";
		try(
				Connection conn=dataSource.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setInt(1, parseInt);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
				return new EmpVo(
						rs.getInt("empno"),rs.getString("ename")
						,rs.getInt("sal"),rs.getString("job")
						);
			rs.close();
		}
		return null;
	}

	public int updateOne(EmpVo bean) throws SQLException {
		String sql="update emp set ename=?,sal=?,job=? where empno=?";
		try(
				Connection conn=dataSource.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setString(1, bean.getEname());
			pstmt.setInt(2, bean.getSal());
			pstmt.setString(3, bean.getJob());
			pstmt.setInt(4, bean.getEmpno());
			return pstmt.executeUpdate();
		}
	}

	public int deleteOne(int empno) throws SQLException {
		String sql="delete from emp where empno=?";
		try(
				Connection conn=dataSource.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setInt(1, empno);
			return pstmt.executeUpdate();
		}
	}
}
