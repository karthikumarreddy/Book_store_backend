package com.bookstore.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.Instant;

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
    private String message;
    private T data;
    private Object errors;
    private Meta meta;
    private Instant timestamp;


    private ApiResponse() {
        this.timestamp = Instant.now();
    }


    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {
        private final ApiResponse<T> response;

        private Builder() {
            this.response = new ApiResponse<>();
        }

        public Builder<T> success(boolean success) {
            response.success = success;
            return this;
        }

        public Builder<T> message(String message) {
            response.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            response.data = data;
            return this;
        }

        public Builder<T> errors(Object errors) {
            response.errors = errors;
            return this;
        }

        public Builder<T> meta(Meta meta) {
            response.meta = meta;
            return this;
        }

        public ApiResponse<T> build() {
            return response;
        }
    }

    
    public static <T> ApiResponse<T> successResponse(String message, T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> successResponse(String message, T data, Meta meta) {
        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .meta(meta)
                .build();
    }

    public static <T> ApiResponse<T> errorResponse(String message, Object errors) {
        return ApiResponse.<T>builder()
                .success(false)
                .message(message)
                .errors(errors)
                .build();
    }

    public static <T> ApiResponse<T> errorResponse(String message) {
        return ApiResponse.<T>builder()
                .success(false)
                .message(message)
                .build();
    }

    // ─── Getters ──────────────────────────────────────────────────────────────

    public boolean isSuccess()    { return success;   }
    public String getMessage()    { return message;   }
    public T getData()            { return data;      }
    public Object getErrors()     { return errors;    }
    public Meta getMeta()         { return meta;      }
    public Instant getTimestamp() { return timestamp; }
}
