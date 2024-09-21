package com.example.backen_springboot.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {
    @NotBlank(message = "Không được để trống email")
    private String email;

    @NotBlank(message = "Không được để trống password")
    private String password;

    @NotBlank(message = "Không được để trống role")
    private String role;
}
