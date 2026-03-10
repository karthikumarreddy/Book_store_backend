package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

import com.bookstore.dto.BooksDTO;
import com.bookstore.services.GetDataSource;

public class BookRepo {
	
	
	public static boolean insertBookData(BooksDTO bookData) throws SQLException{
		Connection connection=(Connection) GetDataSource.getDataSource();
		PreparedStatement preparedStatement=connection.prepareStatement("insert into books values(?,?,?,?,?,?,?);");
		preparedStatement.setString(1, bookData.getId());
		preparedStatement.setString(2, bookData.getTitle());
		preparedStatement.setString(3, bookData.getAuthor());
		preparedStatement.setString(4, bookData.getCategory());
		preparedStatement.setDouble(5, Double.valueOf(bookData.getPrice()));
		preparedStatement.setString(6, bookData.getImage());
		preparedStatement.setString(7, bookData.getDescription());
		return preparedStatement.execute();
	}
}

