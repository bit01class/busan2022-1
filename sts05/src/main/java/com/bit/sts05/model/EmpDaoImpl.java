package com.bit.sts05.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class EmpDaoImpl implements EmpDao<EmpVo> {
	@Autowired
	JdbcTemplate jdbcTemplate;
	RowMapper<EmpVo> mapper=new RowMapper<EmpVo>() {
		
		@Override
		public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new EmpVo(
					rs.getInt("empno"),rs.getInt("sal"),rs.getString("ename")
					,rs.getString("job"),rs.getTimestamp("hiredate")
					);
		}
	};

	public EmpDaoImpl() {
		System.out.println("dao create...");
	}
	
	@Override
	public List<EmpVo> findAll() throws SQLException {
		String sql="select * from emp";
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public EmpVo findObject(int key) throws SQLException {
		return null;
	}

	@Override
	public void insertOne(EmpVo t) throws SQLException {

	}

	@Override
	public int updateOne(EmpVo t) throws SQLException {
		return 0;
	}

	@Override
	public int deleteOne(int key) throws SQLException {
		return 0;
	}

}
