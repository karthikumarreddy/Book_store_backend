package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bookstore.dto.BooksDTO;
import com.bookstore.services.GetDataSource;

public class BookRepo {
	
	
	public static boolean insertBookData(BooksDTO bookData) {
	try {
		Connection connection=(Connection) GetDataSource.getDataSource();
		PreparedStatement preparedStatement=connection.prepareStatement("insert into books") ;
	}catch(Exception e){
		
		
		}
	return true;
	}
}

