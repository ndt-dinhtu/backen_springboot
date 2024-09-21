package com.example.backen_springboot.controllers.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backen_springboot.configuration.components.JwtTokenUtil;
import com.example.backen_springboot.dtos.UserLoginDTO;
import com.example.backen_springboot.model.User;
import com.example.backen_springboot.response.ApiResponse;
import com.example.backen_springboot.response.ResponseData;
import com.example.backen_springboot.services.auth.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("${api.prefix}/v2/auth")
@RequiredArgsConstructor
public class AuthUserController {
    // Instance fields
    private final AuthService authService;
    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping
    public String register( @RequestBody UserLoginDTO userLoginDTO)
            throws Exception {
        User user = authService.createUser(userLoginDTO);

        return jwtTokenUtil.generateToken(user);

    }

    @GetMapping
    public String getMethodName() {
        return "Hello world";
    }

    @GetMapping("/hi")
    public ResponseEntity<ApiResponse> getHi() {
        ApiResponse apiResponse = ApiResponse.builder()
                                        .status(HttpStatus.OK.value())
                                        .message("ok")
                                        .data("Hi")
                                        .build();
        return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(apiResponse);
    }
    

}
