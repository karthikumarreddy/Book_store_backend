package com.bookstore.api;

import java.time.Instant;

public class ApiResponse<T> {

    private boolean success;
	private int statusCode;
    private String message;
    private T data;
	private String errors; // Changed from Exception to List<String> for safety
    private Meta meta;
	private String timestamp;

	public ApiResponse() {

	}

	// All-Args Constructor
	public ApiResponse(boolean success, int statusCode, String message, T data, String errors, Meta meta, String timestamp) {
		this.success = success;
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
		this.errors = errors;
		this.meta = meta;
		this.timestamp = timestamp;
	}

	// --- Getters and Setters ---

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

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
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

	public static <T> ApiResponse<T> success(String message, T data, int statusCode) {
		return new ApiResponse<>(true, statusCode, message, data, null, null, Instant.now().toString());
    }

	public static <T> ApiResponse<T> success(String message, T data, Meta meta, int statusCode) {
		return new ApiResponse<>(true, statusCode, message, data, null, meta, Instant.now().toString());
    }

	// Fixed: success is now FALSE for errors
	public static <T> ApiResponse<T> error(String message, int statusCode) {
		return new ApiResponse<>(false, statusCode, message, null, null, null, Instant.now().toString());
    }

	// Fixed: success is now FALSE, errors is List<String>
	public static <T> ApiResponse<T> error(String message, String errors, int statusCode) {
		return new ApiResponse<>(false, statusCode, message, null, errors, null, Instant.now().toString());
    }
}