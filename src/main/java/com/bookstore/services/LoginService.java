package com.bookstore.services;

import org.mindrot.jbcrypt.BCrypt;

import com.bookstore.api.ApiResponse;
import com.bookstore.dao.UsersDAO;
import com.bookstore.dto.UsersDTO;
import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginService {
	public static String loginValidation(HttpServletRequest request,HttpServletResponse response) {
		
		String fullName=request.getParameter("fullname");
		String password=request.getParameter("password");
		
		
		
		
		UsersDTO user=UsersDAO.findByUser(fullName);
		
		
		if(user==null) {
			
			ApiResponse<Object> apiresponse=ApiResponse.errorResponse("Username not found");
			
			Gson gson=new Gson();
			String json=gson.toJson(apiresponse);
			
			return json;
		}
		
		if(user.getFullName().equals(fullName)) {
			if(BCrypt.checkpw(password,user.getPassword())) {
				
				ApiResponse<Object> apiresponse=ApiResponse.successResponse("Login Successfull",fullName);
				
				
				Gson gson=new Gson();
				String json=gson.toJson(apiresponse);
				
				return json;
			}else {
				ApiResponse<Object> apiresponse=ApiResponse.errorResponse("Password incorrect");
				Gson gson=new Gson();
				String json=gson.toJson(apiresponse);
				
				return json;
			}
		}else {
			
			ApiResponse<Object> apiresponse=ApiResponse.errorResponse("Username Incorrect");
			Gson gson=new Gson();
			String json=gson.toJson(apiresponse);
			
			return json;
			
		}
		
		
		
	}
}
