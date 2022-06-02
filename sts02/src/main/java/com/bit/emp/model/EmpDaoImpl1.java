package com.bit.emp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.cj.jdbc.MysqlDataSourceFactory;

public class EmpDaoImpl1 implements EmpDao {
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<EmpVo> selectAll() throws SQLException {
		String sql="select * from emp";
		List<EmpVo> list=new ArrayList<>();
		
		try(
			Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();	
				){
			while(rs.next())
				list.add(new EmpVo(
						rs.getInt("empno"),rs.getInt("sal")
						,rs.getString("ename"),rs.getString("job")
						,rs.getDate("hiredate")
						));
		}
		return list;
	}
	
	public void insertOne(EmpVo bean) throws SQLException {
		String sql="insert into emp (empno,ename,sal,job,hiredate) values (?,?,?,?,now())";
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

	public int updateOne(EmpVo bean) throws SQLException {
		String sql="update emp set ename=?,sal=?,job=? where empno=?";
		try(
				Connection conn=dataSource.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setInt(4, bean.getEmpno());
			pstmt.setString(1, bean.getEname());
			pstmt.setInt(2, bean.getSal());
			pstmt.setString(3, bean.getJob());
			return pstmt.executeUpdate();
		}
	}

	public int deleteOne(int num) throws SQLException {
		String sql="delete from emp where empno=?";
		try(
				Connection conn=dataSource.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setInt(1, num);
			return pstmt.executeUpdate();
		}
	}
	
	public EmpVo selectOne(int num) throws SQLException {
		String sql="select * from emp where empno=?";
		try(
			Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);	
				){
			pstmt.setInt(1, num);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
				return new EmpVo(
						rs.getInt("empno"),rs.getInt("sal")
						,rs.getString("ename"),rs.getString("job")
						,rs.getDate("hiredate")
						);
		}
		return null;
	}
}

























