package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bookstore.config.ConnectionFactory;
import com.bookstore.dto.BooksDTO;
import com.bookstore.exceptions.ConnectionTimeoutException;

public class BookRepo {
	
	public boolean insertBookData(BooksDTO bookData) throws SQLException, ConnectionTimeoutException {
		
		try(Connection connection = (Connection) ConnectionFactory.getConnectionInstance();){
			PreparedStatement preparedStatement=connection.prepareStatement("insert into books values(?,?,?,?,?,?,?);");
			preparedStatement.setString(1, bookData.getId());
			preparedStatement.setString(2, bookData.getTitle());
			preparedStatement.setString(3, bookData.getAuthor());
			preparedStatement.setString(4, bookData.getCategory());
			preparedStatement.setDouble(5, Double.valueOf(bookData.getPrice()));
			preparedStatement.setString(6, bookData.getImage());
			preparedStatement.setString(7, bookData.getDescription());
			int affectedRows = preparedStatement.executeUpdate();
			if (affectedRows > 0) {
				return true;
			}
			return false;
		} catch (ConnectionTimeoutException e) {
			throw e;
		}
	
	}
}

