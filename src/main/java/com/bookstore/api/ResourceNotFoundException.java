package com.bookstore.api;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4180504319036010598L;

	public ResourceNotFoundException(String message) {
        super(message);
    }

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

    public static ResourceNotFoundException of(String resource, Object id) {
        return new ResourceNotFoundException(resource + " not found with id: " + id);
    }
}


// ─────────────────────────────────────────────────────────────────────────────
// FILE 2 of 3:  BusinessException.java
// Package: com.bookstore.api  (confirmed from WAR bytecode)
// ─────────────────────────────────────────────────────────────────────────────

// package com.bookstore.api;
//
// public class BusinessException extends RuntimeException {
//     public BusinessException(String message) { super(message); }
// }


// ─────────────────────────────────────────────────────────────────────────────
// FILE 3 of 3:  UnauthorizedException.java
// Package: com.bookstore.api  (confirmed from WAR bytecode)
// ─────────────────────────────────────────────────────────────────────────────

// package com.bookstore.api;
//
// public class UnauthorizedException extends RuntimeException {
//     public UnauthorizedException(String message) { super(message); }
// }
