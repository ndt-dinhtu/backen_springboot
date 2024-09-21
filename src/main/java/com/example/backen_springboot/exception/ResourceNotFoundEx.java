package com.example.backen_springboot.exception;


public class ResourceNotFoundEx extends RuntimeException{
    public ResourceNotFoundEx(String message) {
        super(message);
    }
    
}
