package com.ict.erp.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface Common {
	public void setConnection(Connection con);
	public int totalCount(String tableName) throws SQLException;

}
