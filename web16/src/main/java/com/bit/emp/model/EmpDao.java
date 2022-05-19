package com.bit.emp.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bit.util.Mysql;

public class EmpDao {
//crud
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<EmpDto> getList() throws SQLException {
		List<EmpDto> list=new ArrayList<>();
		String sql="select * from emp order by empno desc";
		try {
			pstmt=Mysql.getConnection().prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				EmpDto dto=new EmpDto();
				dto.setDeptno(rs.getInt("deptno"));
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setSal(rs.getInt("sal"));
				dto.setHiredate(rs.getDate("hiredate"));
				list.add(dto);
			}
		}finally {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(Mysql.getConnection()!=null)Mysql.getConnection().close();
		}
		return list;
	}
	public EmpDto getOne(int num) throws SQLException {
		EmpDto bean=null;
		String sql="select * from emp where empno=?";
		try {
			pstmt=Mysql.getConnection().prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bean=new EmpDto();
				bean.setDeptno(rs.getInt("deptno"));
				bean.setEmpno(rs.getInt("empno"));
				bean.setEname(rs.getString("ename"));
				bean.setHiredate(rs.getDate("hiredate"));
				bean.setJob(rs.getString("job"));
				bean.setSal(rs.getInt("sal"));
			}
		}finally {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(Mysql.getConnection()!=null)Mysql.getConnection().close();
		}
		
		return bean;
	}
	public boolean insertOne(EmpDto bean) throws SQLException {
		String sql="insert into emp (empno,ename,sal,hiredate) values (?,?,?,now())";
		try {
//			Mysql.getConnection().setAutoCommit(false);// mysql은 명시적 commit전에는 commit 안됨
			pstmt=Mysql.getConnection().prepareStatement(sql);
			pstmt.setInt(1, bean.getEmpno());
			pstmt.setString(2, bean.getEname());
			pstmt.setInt(3, bean.getSal());
			return pstmt.executeUpdate()>0;
		}finally {
//			if(test)Mysql.getConnection().rollback();
//			else Mysql.getConnection().commit();
			if(pstmt!=null)pstmt.close();
			if(Mysql.getConnection()!=null)Mysql.getConnection().close();
		}
	}
	public void updateOne() {}
	public void deleteOne() {}
	
}




















