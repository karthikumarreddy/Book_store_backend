package com.bookstore.api;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Generic API response wrapper for all endpoints in the Bookstore backend.
 * Package: com.bookstore.api  (matches compiled WAR structure)
 *
 * Fields confirmed from WAR bytecode:
 *   success | message | data<T> | errors | meta | timestamp
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private boolean success;
	private int statusCode;
    private String message;
    private T data;
    private Exception errors;
    private Meta meta;
	private String timestamp;

	public ApiResponse() {

	}

	public ApiResponse(boolean success, int statusCode, String message, T data, Exception errors, Meta meta, String timestamp) {
		super();
		this.success = success;
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
		this.errors = errors;
		this.meta = meta;
		this.timestamp = timestamp;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Exception getErrors() {
		return errors;
	}

	public void setErrors(Exception errors) {
		this.errors = errors;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public static <T> ApiResponse<T> successResponse(String message, T data, int statuCode) {
		return new ApiResponse<T>(true, statuCode, message, data, null, null, LocalDateTime.now().toString());
    }

	public static <T> ApiResponse<T> successResponse(String message, T data, Meta meta, int statuCode) {
		return new ApiResponse<T>(true, statuCode, message, data, null, null, LocalDateTime.now().toString());
    }

	public static <T> ApiResponse<T> errorResponse(String message, Exception errors, int statuCode) {
		return new ApiResponse<T>(true, statuCode, message, null, errors, null, LocalDateTime.now().toString());
    }

	public static <T> ApiResponse<T> errorResponse(String message, int statuCode) {
		return new ApiResponse<T>(true, statuCode, message, null, null, null, LocalDateTime.now().toString());
    }


}
