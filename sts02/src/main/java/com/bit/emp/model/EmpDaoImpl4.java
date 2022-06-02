package com.bit.emp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionOperations;
import org.springframework.transaction.support.TransactionTemplate;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class EmpDaoImpl4 implements EmpDao {
	JdbcTemplate jdbcTemplate;
	
	PlatformTransactionManager transactionManager;
	
	RowMapper<EmpVo> rowMapper=new RowMapper<EmpVo>() {
		
		@Override
		public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new EmpVo(
					rs.getInt("empno"),rs.getInt("sal")
					,rs.getString("ename"),rs.getString("job")
					,rs.getDate("hiredate")
					);
		}
	};
	
	public EmpDaoImpl4(JdbcTemplate jdbcTemplate,PlatformTransactionManager transactionManager) {
		this.jdbcTemplate=jdbcTemplate;
		this.transactionManager=transactionManager;
	}

	@Override
	public List<EmpVo> selectAll() throws SQLException {
		final String sql="select * from emp";
		
		PreparedStatementCreator psc=new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				return conn.prepareStatement(sql);
			}
		};
		
		return jdbcTemplate.query(psc, rowMapper);
	}

	@Override
	public EmpVo selectOne(int num) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteOne(int num) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOne(EmpVo bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertOne(EmpVo bean) throws SQLException {
		
		TransactionStatus status=null;
		TransactionDefinition definition=new DefaultTransactionDefinition();
		status=transactionManager.getTransaction(definition);
		
		try {
			PreparedStatementCreator psc=new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					System.out.println("첫번째 conn:"+conn.hashCode());
					String sql="insert into emp (empno,ename,sal,job,hiredate) value (?,?,?,?,now())";
					PreparedStatement pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1, bean.getEmpno());
					pstmt.setString(2, bean.getEname());
					pstmt.setInt(3, bean.getSal());
					pstmt.setString(4, bean.getJob());
					return pstmt;
				}
			};
			jdbcTemplate.update(psc);
			
			psc=new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					System.out.println("두번째 conn:"+conn.hashCode());
					String sql="insert into emp (empno,ename,sal,job,hiredate) value (?,?,?,?,now())";
					PreparedStatement pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1, bean.getEmpno());
					pstmt.setString(2, bean.getEname());
					pstmt.setInt(3, bean.getSal());
					pstmt.setString(4, bean.getJob());
					return pstmt;
				}
			};
			jdbcTemplate.update(psc);
			transactionManager.commit(status);
		}catch (Exception e) {
			transactionManager.rollback(status);
		}
	}

}
