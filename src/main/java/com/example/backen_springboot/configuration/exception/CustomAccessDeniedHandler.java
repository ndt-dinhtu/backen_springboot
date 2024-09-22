package com.example.backen_springboot.configuration.exception;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.example.backen_springboot.response.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");

        // Tạo đối tượng ApiResponse
        ApiResponse apiResponse = ApiResponse.builder()
                .status(HttpServletResponse.SC_FORBIDDEN)
                .message("Access denied for path: " + request.getServletPath())
                .data(null) // Có thể để null hoặc thêm thông tin khác nếu cần
                .build();

        // Chuyển đổi đối tượng ApiResponse thành JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(apiResponse);

        // Ghi phản hồi vào response
        response.getWriter().write(jsonResponse);

    }

}
