package com.bit.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Emp01DaoTest {
	Logger log=Logger.getLogger(Emp01DaoTest.class);
	Emp01Dao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dao=new Emp01Dao();
	}

	@Test
	public void testSelectAll() throws ClassNotFoundException, SQLException {
		assertTrue(dao.selectAll().size()>0);
		for(EmpVo bean:dao.selectAll()) log.debug(bean);
	}

}
