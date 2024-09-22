package com.example.backen_springboot.exception;


public class PermisionDenyException extends RuntimeException{
    public PermisionDenyException(String message) {
        super(message);
    }
    
}
