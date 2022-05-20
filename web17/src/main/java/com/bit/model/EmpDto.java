package com.bit.model;

import java.util.List;

import org.bson.types.ObjectId;

public class EmpDto {
	private ObjectId id;
	private int empno;
	private String ename;
	private List item;
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public List getItem() {
		return item;
	}
	public void setItem(List item) {
		this.item = item;
	}
	
	
}
