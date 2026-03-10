package com.bookstore.servlets;

import java.io.IOException;
import java.sql.Timestamp;

import com.bookstore.dto.UsersDTO;
import com.bookstore.services.LoginService;
import com.bookstore.services.UsersServices;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login_Servlet
 */
@WebServlet("/login")
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Users() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		
				response.getWriter().write(LoginService.loginValidation(request, response));
=======
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
				response.getWriter().write(UsersServices.validateUser(request));
>>>>>>> branch 'main' of https://github.com/karthikumarreddy/Book_store_backend.git
			}
<<<<<<< HEAD
	
=======
>>>>>>> branch 'main' of https://github.com/karthikumarreddy/Book_store_backend.git

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
