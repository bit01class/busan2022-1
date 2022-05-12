package com.bit.module01.mysql;

public class EmpBean {
	//javaBean class (DTO, VO, Entry)
	private int empno;
	private String ename;
	private int sal;
	
	
	// getter & setter
	// get필드(첫글자를 대문자로
	// set필드(..
	// is필드(..
	
	@Override
	public String toString() {
		return "empno:"+empno+",ename:"+ename+",sal:"+sal;
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


	public int getSal() {
		return sal;
	}


	public void setSal(int sal) {
		this.sal = sal;
	}
}
