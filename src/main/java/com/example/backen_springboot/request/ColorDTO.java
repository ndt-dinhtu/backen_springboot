package com.example.backen_springboot.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColorDTO {
    private String name;

    @NotBlank(message = "Mã hexa không được để trống và không được chứa khoảng trắng")
    @Size(min = 6, max = 6, message = "Mã hexa có 6 kí tự")
    @Pattern(regexp = "^[0-9A-Fa-f]+$", message = "Mã hexa chỉ cho phép ký tự từ 0-9 và A-F")
    private String hexCode;
}
