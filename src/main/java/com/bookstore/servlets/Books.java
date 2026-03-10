package com.bookstore.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/books/*")
public class Books extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Books() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// splitting request URI.

		response.setContentType("application/json");

		String path = request.getRequestURI().substring(request.getContextPath().length() + 1);
		String[] splittedPath = path.split("/"); // ['books', 'path if any'.]

		PrintWriter responseWriter = response.getWriter();


		if (splittedPath.length <= 1) {
			responseWriter.append("{ \"status\": \"success\", \"message\" : \"All books\" }");
		} else {
			responseWriter.append("{ \"status\": \"success\", \"message\" : \"Specific books\" }");
		}


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
