package com.bit.emp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.bit.framework.JdbcTemplate;
import com.bit.framework.RowMapper;
import com.mysql.cj.jdbc.MysqlDataSource;

public class EmpDao {
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
		String sql="select * from emp";
		JdbcTemplate template=new JdbcTemplate(dataSoruce);
		RowMapper rowMapper=new RowMapper() {
			public Object rows(ResultSet rs) throws SQLException{
				return new EmpVo(
						rs.getInt("empno"),rs.getInt("sal"),rs.getString("ename"),rs.getString("job")
						);
			}
		};
		return template.queryForList(sql,rowMapper,new Object[]{});
	}

	public void insertOne(EmpVo bean) throws SQLException {
		String sql="insert into emp (empno,ename,sal,job) values (?,?,?,?)";
		JdbcTemplate template=new JdbcTemplate();
		template.setDataSoruce(dataSoruce);
		Object[] objs=new Object[] {bean.getEmpno(), bean.getEname(), bean.getSal(), bean.getJob()};
		template.executeUpdate(sql, objs);
	}
}










