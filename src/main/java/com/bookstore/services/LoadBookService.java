package com.bookstore.services;

import jakarta.servlet.http.HttpServletRequest;

public class LoadBookService {

	public static String addBook(HttpServletRequest request) {
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String category = request.getParameter("category");
		
		return null;
	}
	
}
