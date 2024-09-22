package com.example.backen_springboot.dtos;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandDTO {
    @NotBlank(message = "Tên không được để trống")
    private String name;

    @Lob
    @NotBlank(message = "Mô tả không được để trống")
    private String description;

    @NotBlank(message = "Nơi sản xuất không được để trống")
    private String country;

    @URL(message = "Địa chỉ website không hợp lệ")
    @NotBlank(message = "Trang web công ty brand không được để trống")
    private String website;
}
