package com.bookstore.util;

import java.io.IOException;

import com.bookstore.api.ApiResponse;

import jakarta.servlet.http.HttpServletResponse;

public class ResponseWrapper {

	public static void writeResponse(HttpServletResponse response, ApiResponse<?> apiResponse) {

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		response.setStatus(apiResponse.getStatusCode());

		try {
			response.getWriter().write(JsonConvertor.convertToJson(apiResponse));
		} catch (IOException e) {
			System.out.println("Error while writing response to the response object.");
		}

	}
}
