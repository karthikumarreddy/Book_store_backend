package com.bookstore.exceptions;

public class ConnectionTimeoutException extends Exception {

	private static final long serialVersionUID = 6883043818046682006L;
	
	public ConnectionTimeoutException(String msg) {
		super(msg);
	}

	public ConnectionTimeoutException(String msg, Throwable cause) {
		super(msg, cause);
	}
	

}
