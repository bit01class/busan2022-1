package com.bit.emp.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bit.util.Mysql;

public class EmpDaoTest {
	Logger log=Logger.getLogger(EmpDaoTest.class);

//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}
//
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}

	@Test
	public void testGetList() throws SQLException {
		EmpDao dao=new EmpDao();
		assertNotNull(dao.getList());
		assertTrue(dao.getList().size()>0);
		for(EmpDto bean: dao.getList()) log.debug(bean);
	}

	@Test
	public void testGetOne() throws SQLException {
		EmpDao dao=new EmpDao();
		assertNotNull(dao.getOne(10000));
		assertEquals("test", dao.getOne(10000).getEname());
		assertTrue(1111==dao.getOne(10000).getSal());
	}
	
	@Test
	public void testInsertOne() throws SQLException {
		EmpDto target=new EmpDto();
		target.setEmpno(10006);
		target.setEname("test");
		target.setSal(1111);
		Mysql.getConnection().setAutoCommit(false);
		EmpDao dao=new EmpDao();
		assertTrue(dao.insertOne(target));
	}
}














