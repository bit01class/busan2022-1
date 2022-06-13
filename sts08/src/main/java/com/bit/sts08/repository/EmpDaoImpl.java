package com.bit.sts08.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.sts08.domain.Emp;

@Repository
public class EmpDaoImpl implements EmpDao{
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<Emp> findAll() {
		return sqlSession.selectList("emp.findAll");
	}

	@Override
	public Emp findOne(int idx) {
		return sqlSession.selectOne("emp.findOne",idx);
	}

	@Override
	public int insertOne(Emp emp) {
		return sqlSession.insert("emp.insertOne",emp);
	}

	@Override
	public int updateOne(Emp emp) {
		return sqlSession.update("emp.updateOne",emp);
	}

	@Override
	public int deleteOne(int idx) {
		return sqlSession.delete("emp.deleteOne",idx);
	}

	@Override
	public int totalSize() {
		return sqlSession.selectOne("emp.totalSize");
	}

	@Override
	public List<Emp> findMany(String val) {
		return sqlSession.selectList("emp.findMany",val);
	}


}










