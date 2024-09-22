package com.example.backen_springboot.exception;

public class ExistsHandlerException extends RuntimeException{
    public ExistsHandlerException(String message) {
        super(message);
    }
    
}
