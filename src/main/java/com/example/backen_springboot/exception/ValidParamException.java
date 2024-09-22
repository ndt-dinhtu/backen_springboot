package com.example.backen_springboot.exception;

public class ValidParamException extends RuntimeException{
    public ValidParamException(String message){
        super(message);
    }
    
}
