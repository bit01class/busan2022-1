package com.bit.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpDaoTest {
	static EmpVo target;
	static int before;
	EmpDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		target=new EmpVo(1007,"test",1000,"tester");
	}

	@Before
	public void setUp() throws Exception {
		dao=new Emp04Dao();
	}

	@Test
	public void test1SelectAll() throws SQLException {
		before=dao.selectAll().size();
		assertTrue(before>0);
	}

	@Test
	public void test2InsertOne() throws SQLException {
		dao.insertOne(target);
		assertSame(before+1, dao.selectAll().size());
	}

	@Test
	public void test4SelectOne() throws SQLException {
		assertEquals(target,dao.selectOne(target.getEmpno()));
	}

	@Test
	public void test3UpdateOne() throws SQLException {
		target.setEname("수정");
		assertTrue(dao.updateOne(target)>0);
	}

	@Test
	public void test5DeleteOne() throws SQLException {
		assertTrue(dao.deleteOne(target.getEmpno())>0);
		assertSame(before, dao.selectAll().size());
	}

}
