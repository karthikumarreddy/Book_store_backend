// ─────────────────────────────────────────────────────────────────────────────
// FILE 1 of 3:  ResourceNotFoundException.java
// Package: com.bookstore.api  (confirmed from WAR bytecode)
//
// FIX applied: WAR had "public type ResourceNotFoundException must be defined in
// its own file" — each exception is now in a separate file as Java mandates.
// ─────────────────────────────────────────────────────────────────────────────

package com.bookstore.api;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    /** Convenience factory — matches WAR signature: (String, Object) */
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
