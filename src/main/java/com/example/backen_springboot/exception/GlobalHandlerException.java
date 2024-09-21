package com.example.backen_springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.backen_springboot.response.ApiResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGeneralException(Exception ex, HttpServletRequest request){
        ApiResponse response = ApiResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("An unexpected error occurred" + ex.getMessage())
                .data(null)
                .build();
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationException(MethodArgumentNotValidException ex){
        StringBuilder errorMessage = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach((error) ->{
            errorMessage.append(error.getDefaultMessage()).append("; ");
        });
        ApiResponse response = ApiResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Validation failed: " + errorMessage.toString())
                .data(null)
                .build();
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(ResourceNotFoundEx.class)
    public ResponseEntity<ApiResponse> handleResourceNotException(ResourceNotFoundEx ex){
        ApiResponse response = ApiResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message("Resource not found: "+ ex.getMessage())
                .data(null)
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @ExceptionHandler(PermisionDenyException.class)
    public ResponseEntity<ApiResponse> handlePermisionDenyException(PermisionDenyException ex){
        ApiResponse response = ApiResponse.builder()
                .status(HttpStatus.FORBIDDEN.value())
                .message("Permission is deny: "+ ex.getMessage())
                .data(null)
                .build();
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }
    @ExceptionHandler(UnauthorException.class)
    public ResponseEntity<ApiResponse> handleUnauthorExceptio(UnauthorException ex){
        ApiResponse response = ApiResponse.builder()
                .status(HttpStatus.UNAUTHORIZED.value())
                .message("Unauthorized: "+ ex.getMessage())
                .data(null)
                .build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
    @ExceptionHandler(ValidParamException.class)
    public ResponseEntity<ApiResponse> handleValidParamException(ValidParamException ex){
        ApiResponse response = ApiResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Valid: "+ ex.getMessage())
                .data(null)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(ExistsHandlerException.class)
    public ResponseEntity<ApiResponse> handleExistsException(ExistsHandlerException ex){
        ApiResponse response = ApiResponse.builder()
                .status(HttpStatus.CONFLICT.value())
                .message("Exists: "+ ex.getMessage())
                .data(null)
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}
