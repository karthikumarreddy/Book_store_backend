package com.bookstore.config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.bookstore.exceptions.ConnectionTimeoutException;
import com.bookstore.exceptions.ResourceNotFoundException;

public class ConnectionFactory {
	private static DataSource datasource;

	static {
		Context ctx;
		try {
			ctx = new InitialContext();
			datasource = (DataSource) ctx.lookup("java:comp/env/jdbc/book_store_db");
		} catch (NamingException e) {
			throw new ResourceNotFoundException("Cannot get Datasource.", e);
		}
	}

	public static Connection getConnectionInstance() throws ConnectionTimeoutException {
		try {
			return datasource.getConnection();
		} catch (SQLException e) {
			throw new ConnectionTimeoutException("Connection Timeout", e);
		}
	}

}
