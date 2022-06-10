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
		return sqlSession.selectOne("dept.selectOne",idx);
	}

	@Override
	public void insertOne(DeptVo bean) throws Exception {
		sqlSession.insert("dept.addOne",bean);
	}

	@Override
	public int updateOne(DeptVo bean) throws Exception {
		return sqlSession.update("dept.updateOne",bean);
	}

	@Override
	public int deleteOne(int idx) throws Exception {
		return sqlSession.delete("dept.deleteOne",idx);
	}

}
