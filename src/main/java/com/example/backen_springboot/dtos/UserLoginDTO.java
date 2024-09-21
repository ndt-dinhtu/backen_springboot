package com.example.backen_springboot.dtos;

import jakarta.validation.constraints.NotBlank;

public class UserLoginDTO {
    @NotBlank(message = "Không được để trống email")
    private String email;

    @NotBlank(message = "Không được để trống password")
    private String password;
}
