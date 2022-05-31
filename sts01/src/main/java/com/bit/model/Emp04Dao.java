package com.bit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

public class Emp04Dao implements EmpDao {
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public List<EmpVo> selectAll() throws SQLException {
		String sql="select * from emp";
		return template.query(sql, new RowMapper<EmpVo>() {

			@Override
			public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new EmpVo(
						rs.getInt("empno"),rs.getString("ename")
						,rs.getInt("sal"),rs.getString("job")
						);
			}});
	}

	@Override
	public void insertOne(EmpVo bean) throws SQLException {
		String sql="insert into emp (empno,ename,sal,job) values (?,?,?,?)";
		template.update(sql,bean.getEmpno(),bean.getEname(),bean.getSal(),bean.getJob());
	}

	@Override
	public EmpVo selectOne(int parseInt) throws SQLException {
		String sql="select * from emp where empno=?";
		return template.queryForObject(sql, new RowMapper<EmpVo>() {

			@Override
			public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new EmpVo(
						rs.getInt("empno"),rs.getString("ename")
						,rs.getInt("sal"),rs.getString("job")
						);
			}
			
		},parseInt);
	}

	@Override
	public int updateOne(EmpVo bean) throws SQLException {
		String sql="update emp set job=?,ename=?,sal=? where empno=?";
		return template.update(sql,bean.getJob(),bean.getEname(),bean.getSal(),bean.getEmpno());
	}

	@Override
	public int deleteOne(int empno) throws SQLException {
		String sql="delete from emp where empno=?";
		return template.update(sql,empno);
	}

}













