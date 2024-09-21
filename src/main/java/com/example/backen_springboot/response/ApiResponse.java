package com.example.backen_springboot.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    @SuppressWarnings("unused")
    private int status;

    @SuppressWarnings("unused")
    private String message;

    @SuppressWarnings("unused")
    private Object data;
    
}
