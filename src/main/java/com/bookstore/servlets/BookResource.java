package com.bookstore.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.bookstore.services.BookService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookResource
 */
@WebServlet("/api/books/*")
public class BookResource extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static BookService service;

	public BookResource() {
        super();
		service = new BookService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// splitting request URI.

		response.setContentType("application/json");

		String path = request.getRequestURI().substring(request.getContextPath().length() + 1);
		String[] splittedPath = path.split("/"); // ['books', 'path if any'.]

		PrintWriter responseWriter = response.getWriter();

		if (splittedPath.length <= 1) { // ['books'] => base url -> all books
			responseWriter.append(service.getAllBook());
		} else {
			responseWriter.append("{ \"status\": \"success\", \"message\" : \"Specific books\" }");
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.getWriter().write(service.saveBook(request));
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
