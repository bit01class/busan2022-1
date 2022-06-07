package com.bit.sts04.model;

import java.sql.SQLException;
import java.util.List;

public interface EmpDao<T> {

	List<T> findAll() throws SQLException;
	T findOne(int idx) throws SQLException;
	void insertOne(T obj) throws SQLException;
	int updateOne(T obj) throws SQLException;
	int deleteOne(int idx) throws SQLException;
}
