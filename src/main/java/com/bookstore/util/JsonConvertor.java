package com.bookstore.util;

import com.bookstore.api.ApiResponse;
import com.google.gson.Gson;

public class JsonConvertor {

	private static final Gson gson = new Gson();
	
	public static String convertToJson(ApiResponse data){
		return gson.toJson(data);
	}
}
