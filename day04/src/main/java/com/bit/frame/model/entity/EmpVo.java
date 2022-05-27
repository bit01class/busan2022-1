package com.bit.frame.model.entity;

public class EmpVo {

	private int empno,sal;
	private String ename,job;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Override
	public String toString() {
		return "{\"empno\":" + empno + ", \"sal\":" + sal + ", \"ename\":\"" + ename + "\", \"job\":\"" + job + "\"}";
	}
	
	
}
