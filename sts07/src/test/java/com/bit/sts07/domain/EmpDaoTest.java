package com.bit.sts07.domain;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpDaoTest {
	
	static EmpDao empDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext ac=null;
//		new ClassPathXmlApplicationContext("/application-context.xml");
//		new FileSystemXmlApplicationContext("c:\\~~\\sts07/src/main/webapp/WEB-INF/spring/root-context.xml");
//		new FileSystemXmlApplicationContext("./src/main/webapp/WEB-INF/spring/root-context.xml");
//		ac=new GenericXmlApplicationContext("classpath:/WEB-INF/spring/root-context.xml");
		ac=new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		empDao=ac.getBean(EmpDao.class);
	}

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void test1DataSource() throws BeansException, SQLException {
		ApplicationContext ac=null;
		ac=new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		ac.getBean(DataSource.class).getConnection().close();
	}

	@Test
	public void test2FindAll() throws SQLException {
		assertNotNull(empDao);
		assertNotNull(empDao.findAll());
		assertNotEquals(0,empDao.findAll().size());
	}
//
//	@Test
//	public void testFindOne() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInsertOne() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateOne() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteOne() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAllSize() {
//		fail("Not yet implemented");
//	}

}
