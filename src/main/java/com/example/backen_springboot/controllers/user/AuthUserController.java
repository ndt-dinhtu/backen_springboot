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


import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("${api.prefix}/v2/auth")
@RequiredArgsConstructor
public class AuthUserController {
    // Instance fields
    private final AuthService authService;
    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody UserLoginDTO userLoginDTO, BindingResult result)
            throws Exception {

        if (result.hasErrors()) {
            return ResponseData.responseBindingResult(result);
        }
        User user = authService.createUser(userLoginDTO);

        String token = jwtTokenUtil.generateToken(user);

        return ResponseData.responseOk(
                "Tạo tài khoản thành công",
                token);

    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@Valid @RequestBody UserLoginDTO userLoginDTO, BindingResult result)
            throws Exception {
        if (result.hasErrors()) {
            return ResponseData.responseBindingResult(result);

        }

        String token = authService.login(userLoginDTO);

        return ResponseData.responseOk("Đăng nhập thành công", token);
    }
    
}
