package com.example.backen_springboot.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public class ResponseData {
    
    //Response khi thành công ( message, data)
    // gọi ResponseData.responseOk
    public static <T> ResponseEntity<ApiResponse> responseOk(String message, T data) {
        ApiResponse apiResponse = ApiResponse.builder()
                                            .status(HttpStatus.OK.value())
                                            .message(message)
                                            .data(data)
                                            .build();
        return ResponseEntity.ok().body(apiResponse);
    }

    // Response khi có lỗi
    // Bên controller bắt lỗi trước - if(result.hasError())
    // gọi: ResponseData.responseBindingResult
    public static ResponseEntity<ApiResponse> responseBindingResult(BindingResult bindingResult) {
        List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage).toList();
            ApiResponse apiResponse = ApiResponse.builder()
                    .status(HttpStatus.BAD_REQUEST.value())
                    .message("Validation failed")
                    .data(errors)
                    .build();
            return ResponseEntity.badRequest().body(apiResponse);
    }

    // Response khi xóa ( truyền id hoặc null) -> 
    // gọi: ResponseData.responseNoContent
    public static <T> ResponseEntity<ApiResponse>  responseNoContent(String message, T data) {
        ApiResponse apiResponse = ApiResponse.builder()
                                            .status(HttpStatus.OK.value())
                                            .message(message)
                                            .data(data)
                                            .build();
        return ResponseEntity.ok().body(apiResponse);
    }

    // Response khi gặp trường hợp lỗi ( user null hay id null sau khi truy vấn repo)
    // gọi : ResponseData.responseBadRequest
    public static <T> ResponseEntity<ApiResponse> responseBadRequest(String message, T data) {
        ApiResponse apiResponse = ApiResponse.builder()
                                            .status(HttpStatus.BAD_REQUEST.value())
                                            .message("Bad request")
                                            .data(data)
                                            .build();
        return ResponseEntity.badRequest().body(apiResponse);
    }
}
