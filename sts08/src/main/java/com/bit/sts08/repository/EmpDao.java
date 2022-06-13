package com.bit.sts08.repository;

import java.util.List;

import com.bit.sts08.domain.Emp;

public interface EmpDao {

	List<Emp> findAll();
	Emp findOne(int idx);
	int insertOne(Emp emp);
	int updateOne(Emp emp);
	int deleteOne(int idx);
	int totalSize();
	List<Emp> findMany(String val);
}
