package com.bookstore.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginService {
	public String loginValidation(HttpServletRequest request,HttpServletResponse response) {
		
		String fullName=request.getParameter("fullname");
		String paasword=request.getParameter("password");
		
		
		UserDAO userdao=UserDAO();
		
		User user=userdao.getUserbyName(fullName);
		boolean flag=false;
		
		
		if(user==null) {
			String json=ApiResponse.errorResponse(flag,"Username is null");
			return json;
		}
		
		
		if(fullname.)
		
		
		return null;
	}
}
