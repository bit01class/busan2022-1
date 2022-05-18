package com.bit.model;

import java.sql.Timestamp;

public class EmpDto {
	private int empno,sal;
	private String ename,job;
	private Timestamp hiredate;
	
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
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
	public Timestamp getHiredate() {
		return hiredate;
	}
	public void setHiredate(Timestamp hiredate) {
		this.hiredate = hiredate;
	}
	@Override
	public String toString() {
		return "EmpDto [empno=" + empno + ", sal=" + sal + ", ename=" + ename + ", job=" + job + ", hiredate="
				+ hiredate + "]";
	}
	
	
	
}
