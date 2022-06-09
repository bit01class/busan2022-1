package com.bit.sts06.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmpVoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		EmpVo bean=new EmpVo(); 
		EmpVo bean2=new EmpVo(2222,1000,"test","test",null);
		bean.setEmpno(1111);
		bean2.setEmpno(2222);
		System.out.println(bean);
	}

}
