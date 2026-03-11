package com.bookstore.services;

import org.mindrot.jbcrypt.BCrypt;

import com.bookstore.api.ApiResponse;
import com.bookstore.dao.UsersDAO;
import com.bookstore.dto.UsersDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SignupService {
	public static String Signup(HttpServletRequest request, HttpServletResponse response){
		String fullName=request.getParameter("fullname");
		String password=BCrypt.hashpw(request.getParameter("password"),BCrypt.gensalt());
		String email=request.getParameter("email");
		boolean isActive=false;
		ObjectMapper mapper = new ObjectMapper();
		if(fullName!=null && password!=null &&email!=null) {
			UsersDTO user=new UsersDTO();
			user.setFullName(fullName);
			user.setPassword(password);
			user.setEmail(email);
			user.setIs_active(isActive);
			UsersDAO.addUser(user);
			 return ApiResponse.successResponse("Sign up successful", null);
        }		
		
		return ApiResponse.errorResponse("something went wrong ",false);
	}

}
