package com.bookstore.services;

import java.sql.SQLException;
import java.util.List;

import com.bookstore.api.ApiResponse;
import com.bookstore.dao.BookRepo;
import com.bookstore.dto.BooksDTO;
import com.bookstore.exceptions.ConnectionTimeoutException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BookService {


	BookRepo repo;

	public BookService() {
		repo = new BookRepo();
	}

	public void findRequest() {

	}

	public ApiResponse<List<BooksDTO>> getAllBook() {
		try {
			ApiResponse<List<BooksDTO>> res;
			List<BooksDTO> getData = null;

			getData = repo.getAllBooks();
			if (getData != null) {
				res = ApiResponse.success("Book Created !", getData, HttpServletResponse.SC_OK);
			} else {
				res = ApiResponse.success("Book creation failed", null, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
			return res;
		} catch (SQLException e) {
			return ApiResponse.error(e.getMessage(), e.getClass().toString(), HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		} catch (ConnectionTimeoutException e) {
			return ApiResponse.error(e.getMessage(), e.getClass().toString(), HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		} catch (IllegalArgumentException e) {
			return ApiResponse.error(e.getMessage(), e.getClass().toString(), HttpServletResponse.SC_BAD_REQUEST);
		}
		

	}
	public void getBookId(Integer id) {
		
	}

	/**
	 * This method responsible for transfer book data to DAO
	 * 
	 * @param HttpServletRequest book data
	 */

	public ApiResponse<Boolean> saveBook(HttpServletRequest request) {
		try {
			String title = request.getParameter("title").trim();
			String author = request.getParameter("author").trim();
			String category = request.getParameter("category").trim();
			Double price = Double.valueOf(request.getParameter("price"));
			// String image = request.getParameter("image").trim();
			String image = "dummy path";
			String description = request.getParameter("description").trim();
			

			
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
			
			// if(image==null || image.equals("")) {
			// throw new IllegalArgumentException("Image must not empty");
			// }
	
			if(description==null || description.equals("")) {
				throw new IllegalArgumentException("description must not empty");
			}
			
			boolean inserted;

			inserted = repo.insertBookData(new BooksDTO(title, author, category, price, image, description));

			ApiResponse<Boolean> res;

			if (inserted) {
				res = ApiResponse.success("Book Created !", null, HttpServletResponse.SC_CREATED);
			} else {
				res = ApiResponse.error("Book creation failed", "Unexpected Exception", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}

			return res;

		} catch (SQLException e) {
			return ApiResponse.error(e.getMessage(), e.getClass().toString(), HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		} catch (ConnectionTimeoutException e) {
			return ApiResponse.error(e.getMessage(), e.getClass().toString(), HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}catch (IllegalArgumentException e) {
			return ApiResponse.error(e.getMessage(), e.getClass().toString(), HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
