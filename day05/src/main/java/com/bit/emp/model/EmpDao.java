package com.bit.emp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.bit.framework.JdbcTemplate;
import com.bit.framework.RowMapper;
import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.cj.jdbc.MysqlDataSourceFactory;

public class EmpDao {
	JdbcTemplate<EmpVo> template=new JdbcTemplate<EmpVo>();
	RowMapper<EmpVo> mapper=new RowMapper<EmpVo>() {
		
		@Override
		public EmpVo rows(ResultSet rs) throws SQLException {
			return new EmpVo(
					rs.getInt("empno"),rs.getInt("sal"),rs.getString("ename"),rs.getString("job")
					);
		}
	};
	
	public EmpDao() throws SQLException{
		
		String url="jdbc:mysql://localhost:3306/scott";
		String user="user01";
		String password="1234";
		MysqlDataSource dataSource=new MysqlDataSource();
//		MysqlDataSource dataSource=new MysqlConnectionPoolDataSource();
		dataSource.setUrl(url);
		dataSource.setUser(user);
		dataSource.setPassword(password);
		template.setDataSoruce(dataSource);
		
	}

	public List<EmpVo> selectAll() throws SQLException {
		String sql="select * from emp";
		return template.queryForList(sql, mapper);
	}
	
	public EmpVo selectOne(int num) throws SQLException{
		String sql="select * from emp where empno=?";
		return template.queryForObject(sql,mapper, num);
	}
	
	public int updateOne(EmpVo bean) throws SQLException {
		String sql="update emp set ename=?,sal=?,job=? where empno=?";
		return template.executeUpdate(sql, bean.getEname(),bean.getSal(),bean.getJob(),bean.getEmpno());
	}
	
	public void insertOne(EmpVo bean) throws SQLException {
		String sql="insert into emp (empno,ename,sal,job) values (?,?,?,?)";
		Object[] objs=new Object[] {bean.getEmpno(), bean.getEname(), bean.getSal(), bean.getJob()};
		template.executeUpdate(sql, objs);
	}
	
	public int deleteOne(int num) throws SQLException {
		String sql="delete from emp where empno=?";
		return template.executeUpdate(sql, num);
	}
}










