package com.bit.sts06.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class EmpDao01Impl implements EmpDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	RowMapper<EmpVo> mapper=new RowMapper<EmpVo>() {
		
		@Override
		public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new EmpVo(rs.getInt("empno"),rs.getInt("sal")
					,rs.getString("ename"),rs.getString("job"),rs.getTimestamp("hiredate"));
		}
	};

	@Override
	public List<EmpVo> findAll() throws Exception {
		String sql="select * from emp";
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public EmpVo findOne(int idx) throws Exception {
		String sql="select * from emp where empno=?";
		return jdbcTemplate.queryForObject(sql, mapper,idx);
	}

	@Override
	public void insertOne(EmpVo bean) throws Exception {
		String sql="insert into emp (ename,sal,job,empno,hiredate) values (?,?,?,?,now())";
		jdbcTemplate.update(sql,bean.getEname(),bean.getSal(),bean.getJob(),bean.getEmpno());
	}

	@Override
	public int updateOne(EmpVo bean) throws Exception {
		String sql="update emp set ename=?,sal=?,job=? where empno=?";
		return jdbcTemplate.update(sql,bean.getEname(),bean.getSal(),bean.getJob(),bean.getEmpno());
	}

	@Override
	public int deleteOne(int idx) throws Exception {
		String sql="delete from emp where empno=?";
		return jdbcTemplate.update(sql,idx);
	}

	@Override
	public int findSize() throws Exception {
		String sql="select count(*) from emp";
		return jdbcTemplate.queryForInt(sql);  // rs.getInt(1), rs.getInt("cnt")
	}

}











