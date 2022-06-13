package com.bit.sts08;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class TestBean {
	
	@Autowired
	SqlSession sqlSession;

	@Test
	public void test() throws SQLException {
			assertNotNull(sqlSession);
			assertNotEquals(0,sqlSession.selectList("emp.findAll").size());
			for(Object bean : sqlSession.selectList("emp.findAll")) {
				log.debug(bean.toString());
			}
	}

}













