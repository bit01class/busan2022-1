package com.bit.sts07.domain;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDaoImpl implements DeptDao {
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<DeptVo> findAll() throws Exception {
		return sqlSession.selectList("dept.selectAll");
	}

	@Override
	public DeptVo findOne(int idx) throws Exception {
		return null;
	}

	@Override
	public void insertOne(DeptVo bean) throws Exception {

	}

	@Override
	public int updateOne(DeptVo bean) throws Exception {
		return 0;
	}

	@Override
	public int deleteOne(int idx) throws Exception {
		return 0;
	}

}
