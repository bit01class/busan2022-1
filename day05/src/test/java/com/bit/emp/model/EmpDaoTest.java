package com.bit.emp.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmpDaoTest {
	EmpDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dao=new EmpDao();
	}

	@Test
	public void testSelectAll() throws SQLException {
		assertTrue(dao.selectAll().size()>0);
	}

	@Test
	public void testInsertOne() throws SQLException {
//		dao.conn.setAutoCommit(false);
		EmpVo target=new EmpVo(1012,1000,"test","tester");
		dao.insertOne(target);
		
//		dao=new EmpDao();
//		dao.conn.setAutoCommit(false);
//		target=new EmpVo(1010,1000,"test","tester");
//		try {
//			dao.insertOne(target);
//			assertFalse(true);
//		}catch (Exception e) {
//			assertFalse(false);
//		}
	}
}










