package com.bit.sts07.domain;

import java.util.List;

public interface DeptDao {
	
	List<DeptVo> findAll() throws Exception;
	DeptVo findOne(int idx) throws Exception;
	void insertOne(DeptVo bean) throws Exception;
	int updateOne(DeptVo bean) throws Exception;
	int deleteOne(int idx) throws Exception;
}
