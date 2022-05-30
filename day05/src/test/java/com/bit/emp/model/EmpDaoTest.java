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

}
