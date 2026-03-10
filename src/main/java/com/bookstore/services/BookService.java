package com.bookstore.services;

import java.util.List;

import com.bookstore.api.ApiResponse;
import com.bookstore.dao.BookRepo;
import com.bookstore.dto.BooksDTO;

import jakarta.servlet.http.HttpServletRequest;

public class BookService {

	public void findRequest() {

	}
	public List<BooksDTO> getAllBook() {
		List<BooksDTO> book = null;
		return book;
	}
	public void getBookId(Integer id) {
		
	}
	
	public String saveook(HttpServletRequest request) {
		try {
			String id = request.getParameter("id").trim();
			String title = request.getParameter("title").trim();
			String author = request.getParameter("author").trim();
			String category = request.getParameter("category").trim();
			Double price = Double.valueOf(request.getParameter("price"));
			String image = request.getParameter("image").trim();
			String description = request.getParameter("description").trim();
			
			if(id==null || id.equals("")) {
				throw new IllegalArgumentException("Id must not empty"); 
			}
			
			if(title==null || title.equals("")) {
				throw new IllegalArgumentException("Title must not empty"); 
			}
			
			if(author==null || author.equals("")) {
				throw new IllegalArgumentException("Author must not empty"); 
			}
			
			if(price==null || price.equals("")) {
				throw new IllegalArgumentException("Price must not empty"); 
			}
			
			if(category==null || category.equals("")) {
				throw new IllegalArgumentException("Category must not empty"); 
			}
			
			if(image==null || image.equals("")) {
				throw new IllegalArgumentException("Image must not empty"); 
			}
	
			if(description==null || description.equals("")) {
				throw new IllegalArgumentException("description must not empty"); 
			}
			
			BookRepo.insertBookData(new BooksDTO(id, title, author, category, price, image, description));

			ApiResponse.error();
		}catch (IllegalArgumentException e) {
			return new ApiResponse.errorResponse(e.getMessage(), e);
		}
	}
}
