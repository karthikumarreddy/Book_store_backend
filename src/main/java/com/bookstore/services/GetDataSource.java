package com.bookstore.services;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class GetDataSource {
		public static DataSource getDataSource() throws Exception {
	        Context ctx = new InitialContext();
	        return (DataSource) ctx.lookup("java:comp/env/jdbc/book_store_db");
	    }

}
