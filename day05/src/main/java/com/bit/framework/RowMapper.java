package com.bit.framework;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {

	T rows(ResultSet rs) throws SQLException;
}
