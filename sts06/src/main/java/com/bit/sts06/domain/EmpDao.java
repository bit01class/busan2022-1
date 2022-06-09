package com.bit.sts06.domain;

import java.util.List;

public interface EmpDao {

	List<EmpVo> findAll() throws Exception;
	EmpVo findOne(int idx) throws Exception;
	void insertOne(EmpVo bean) throws Exception;
	int updateOne(EmpVo bean) throws Exception;
	int deleteOne(int idx) throws Exception;
	int findSize() throws Exception;
}
