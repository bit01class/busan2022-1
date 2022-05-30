package com.bit.emp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bit.framework.JdbcTemplate;
import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

public class EmpDao {
	Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	DataSource dataSoruce;
	
	public EmpDao(){
		
		String url="jdbc:mysql://localhost:3306/scott";
		String user="user01";
		String password="1234";
		MysqlDataSource dataSource=new MysqlDataSource();
		dataSource.setUrl(url);
		dataSource.setUser(user);
		dataSource.setPassword(password);
		this.dataSoruce=dataSource;
		
	}

	public List<EmpVo> selectAll() throws SQLException {
		List<EmpVo> list=new ArrayList<>();
		String sql="select * from emp";
		Connection conn=dataSoruce.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) list.add(new EmpVo(
					rs.getInt("empno"),rs.getInt("sal"),rs.getString("ename"),rs.getString("job")
					));
		}finally {
			close();
		}
		return list;
	}

	public void insertOne(EmpVo bean) throws SQLException {
		String sql="insert into emp (empno,ename,sal,job) values (?,?,?,?)";
		JdbcTemplate template=new JdbcTemplate();
		template.setDataSoruce(dataSoruce);
		Object[] objs=new Object[] {bean.getEmpno(), bean.getEname(), bean.getSal(), bean.getJob()};
		template.executeUpdate(sql, objs);
	}
	
	public void close() throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
}










