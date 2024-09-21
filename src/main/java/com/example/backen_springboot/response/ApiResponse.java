package com.example.backen_springboot.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ApiResponse {

    private int status;


    private String message;


    private Object data;
    
}
