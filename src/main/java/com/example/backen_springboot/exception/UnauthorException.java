package com.example.backen_springboot.exception;


public class UnauthorException extends RuntimeException{
    public UnauthorException(String message) {
        super(message);
    }
    
}
