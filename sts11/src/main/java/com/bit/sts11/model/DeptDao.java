package com.bit.sts11.model;

import java.util.List;

import com.bit.sts11.domain.Dept;

public interface DeptDao {

	List<Dept> findAll();

}