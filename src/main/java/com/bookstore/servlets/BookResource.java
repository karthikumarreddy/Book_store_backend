package com.bookstore.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.bookstore.services.BookService;
import com.bookstore.util.ResponseWrapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


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

		String path = request.getRequestURI().substring(request.getContextPath().length() + 1);
		String[] splittedPath = path.split("/"); // ['books', 'path if any'.]

		PrintWriter responseWriter = response.getWriter();

		if (splittedPath.length <= 1) { // ['books'] => base url -> all books
			ResponseWrapper.writeResponse(response, service.getAllBook());
		} else {
			ResponseWrapper.writeResponse(response, service.getAllBook());
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ResponseWrapper.writeResponse(response, service.saveBook(request));

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
