package com.bookstore.services;

import com.bookstore.dao.UsersDAO;
import com.bookstore.dto.UsersDTO;

public class UsersServices {
	public static String validateUser(String userName,String password) {
		UsersDTO user=UsersDAO.findByUser(userName);
		if(user!=null) {
			if(user.getFullName().equals(userName) && user.getPassword().equals(password)) {
				return "login sucessfull";
			}
		}
		return "login failed";
	}
	public static String addUser(UsersDTO user) {
		if(user!=null) {
			UsersDAO.addUser(user);
			return "account created sucessfull login to continue ";
		}
		return"something went wront try later";
		
	}
}
