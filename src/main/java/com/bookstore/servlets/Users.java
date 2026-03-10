package com.bookstore.servlets;

import java.io.IOException;
import java.sql.Timestamp;

import com.bookstore.dto.UsersDTO;
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
		String fullName=request.getParameter("fullName");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String created_at=request.getParameter("created_at");
		String updated_at=request.getParameter("updated_at");
		String is_active=request.getParameter("is_active");
		UsersDTO user=null;
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		if(fullName!=null) {
			user=new UsersDTO(fullName,password,email,created_at, updated_at,is_active);
			if(user!=null) {
				response.getWriter().write(UsersServices.validateUser(user.getUserName(), user.getPassword()));
			}
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
