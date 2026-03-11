package com.bookstore.services;

import org.mindrot.jbcrypt.BCrypt;

import com.bookstore.api.ApiResponse;
import com.bookstore.dao.UsersDAO;
import com.bookstore.dto.UsersDTO;
import com.bookstore.util.JsonConvertor;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UsersService {

	public static String loginValidation(HttpServletRequest request,HttpServletResponse response) {
		
		String fullName=request.getParameter("fullname");
		String password=request.getParameter("password");
		UsersDTO user=UsersDAO.findByUser(fullName);
		if(user==null) {
			return JsonConvertor.convertToJson(ApiResponse.errorResponse("Username not found",HttpServletResponse.SC_UNAUTHORIZED));
			
		}
		
		if(user.getFullName().equals(fullName)) {
			if(BCrypt.checkpw(password,user.getPassword())) {
				
				return JsonConvertor.convertToJson(ApiResponse.successResponse("Login Successfull",fullName, HttpServletResponse.SC_OK));
			}else {
				return JsonConvertor.convertToJson(ApiResponse.errorResponse("Password incorrect",HttpServletResponse.SC_UNAUTHORIZED));
			}
		}else {
			return JsonConvertor.convertToJson(ApiResponse.errorResponse("Username Incorrect",HttpServletResponse.SC_UNAUTHORIZED));
			
		}
		
		
		
	}
	
	public static String signUp(HttpServletRequest request, HttpServletResponse response){
		String fullName=request.getParameter("fullname");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		boolean isActive=false;
		ObjectMapper mapper = new ObjectMapper();
		if(fullName!=null && password!=null &&email!=null) {
			password=BCrypt.hashpw(request.getParameter("password"),BCrypt.gensalt());
			UsersDTO user=new UsersDTO();
			user.setFullName(fullName);
			user.setPassword(password);
			user.setEmail(email);
			user.setIs_active(isActive);
			UsersDAO.addUser(user);
			return JsonConvertor.convertToJson( ApiResponse.successResponse("Sign up successful",fullName, HttpServletResponse.SC_CREATED));
        }		
		
		return JsonConvertor.convertToJson(ApiResponse.errorResponse("something went wrong ",HttpServletResponse.SC_UNAUTHORIZED));
		
	}

}
