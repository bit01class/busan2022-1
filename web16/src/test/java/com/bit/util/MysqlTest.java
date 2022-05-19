package com.bit.util;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class MysqlTest {

	@Test
	public void testGetConnection() throws SQLException {
		Connection target=Mysql.getConnection();
		assertNotNull(target);
		assertFalse(target.isClosed());
		assertEquals(target, Mysql.getConnection());
		target.close();
		assertNotNull(Mysql.getConnection());
		assertFalse(Mysql.getConnection().isClosed());
		assertNotEquals(target, Mysql.getConnection());
		Mysql.getConnection().close();
	}

}
