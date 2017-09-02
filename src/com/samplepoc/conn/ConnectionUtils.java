package com.samplepoc.conn;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionUtils {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		return (Connection) MySqlConnectionUtils.getMySQLConnection();
	}

	public static void closeQuietly(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}

	public static void rollbackQuietly(Connection conn) {
		try {
			conn.rollback();
		} catch (Exception e) {
		}
	}
}
