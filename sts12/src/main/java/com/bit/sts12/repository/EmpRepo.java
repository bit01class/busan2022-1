package com.bit.sts12.repository;

import java.util.List;

import com.bit.sts12.domain.Emp;

public interface EmpRepo {

	List<Emp> findAll();
	Emp findOne(int empno);
	int insertOne(Emp emp);
	int updateOne(Emp emp);
	int deleteOne(int empno);
}
