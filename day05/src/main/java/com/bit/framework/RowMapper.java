package com.bit.framework;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper {

	Object rows(ResultSet rs) throws SQLException;
}
