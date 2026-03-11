package com.bookstore.services;

import org.mindrot.jbcrypt.BCrypt;

import com.bookstore.api.ApiResponse;
import com.bookstore.dao.UsersDAO;
import com.bookstore.dto.UsersDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UsersService {

	public static ApiResponse<UsersDTO> loginValidation(HttpServletRequest request,HttpServletResponse response) {
		
		String fullName=request.getParameter("fullname");
		String password=request.getParameter("password");
		UsersDTO user=UsersDAO.findByUser(fullName);
		 	
		if(user==null) {
			return ApiResponse.error("Username not found",HttpServletResponse.SC_UNAUTHORIZED);
		}
		if(BCrypt.checkpw(password,user.getPassword())) {
				return ApiResponse.success("Login Successfull",user, HttpServletResponse.SC_OK);
		}
		return ApiResponse.error("Username Incorrect",HttpServletResponse.SC_UNAUTHORIZED);
	}
	public static ApiResponse<Boolean> signUp(HttpServletRequest request, HttpServletResponse response){
		
		String fullName=request.getParameter("fullname");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		boolean isActive=false;
		ObjectMapper mapper = new ObjectMapper();
		 ApiResponse<Boolean> result = null;
		if(fullName!=null && password!=null&&!password.isBlank() &&email!=null) {
			password=BCrypt.hashpw(request.getParameter("password"),BCrypt.gensalt());
			UsersDTO user=new UsersDTO();
			user.setFullName(fullName);
			user.setPassword(password);
			user.setEmail(email);
			user.setIs_active(isActive);
			 boolean isSignup=UsersDAO.addUser(user);
			 if(isSignup) {
				 result=ApiResponse.success("Sign up successful",isSignup, HttpServletResponse.SC_CREATED);
			 }else {
				 result=ApiResponse.error("something went wrong ",HttpServletResponse.SC_UNAUTHORIZED);
			 }
        }
		 return result;
	}

}
