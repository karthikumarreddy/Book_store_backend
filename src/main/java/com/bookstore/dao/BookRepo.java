package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bookstore.config.ConnectionFactory;
import com.bookstore.dto.BooksDTO;
import com.bookstore.exceptions.ConnectionTimeoutException;

public class BookRepo {
	
	public boolean insertBookData(BooksDTO bookData) throws SQLException, ConnectionTimeoutException {
		
		try (Connection connection = (Connection) ConnectionFactory.getConnectionInstance();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"insert into books (title,author,category,price,image,description) values(?,?,?,?,?,?);");) {

			preparedStatement.setString(1, bookData.getTitle());
			preparedStatement.setString(2, bookData.getAuthor());
			preparedStatement.setString(3, bookData.getCategory());
			preparedStatement.setDouble(4, Double.valueOf(bookData.getPrice()));
			preparedStatement.setString(5, bookData.getImage());
			preparedStatement.setString(6, bookData.getDescription());
			int affectedRows = preparedStatement.executeUpdate();
			if (affectedRows > 0) {
				return true;
			}
			return false;
		} catch (ConnectionTimeoutException e) {
			throw e;
		}
	
	}

	public List<BooksDTO> getAllBooks() throws SQLException, ConnectionTimeoutException {
		List<BooksDTO> bookList = new ArrayList<>();
		try (Connection connection = ConnectionFactory.getConnectionInstance();
				Statement statement = connection.createStatement()) {
			ResultSet rs = statement.executeQuery("select * from books");
			while (rs.next()) {
				bookList.add(new BooksDTO(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
						rs.getString("category"), rs.getDouble("price"), rs.getString("image"),
						rs.getString("description")));
			}

		} catch (ConnectionTimeoutException e) {
			throw e;
		}
		return bookList;
	}
	
	public Optional<BooksDTO> getBookByID(long id) throws SQLException, ConnectionTimeoutException {
		BooksDTO bookData =null;
		try (Connection connection = ConnectionFactory.getConnectionInstance();
				PreparedStatement prepareStatement = connection.prepareStatement("select * from books where id=?")) {
			prepareStatement.setLong(1, id);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				bookData=new BooksDTO(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
						rs.getString("category"), rs.getDouble("price"), rs.getString("image"),
						rs.getString("description"));
			}

		} catch (ConnectionTimeoutException e) {
			throw e;
		}
		return Optional.of(bookData);
		
	}
	
	

}

