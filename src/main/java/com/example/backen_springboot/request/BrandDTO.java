package com.example.backen_springboot.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BrandDTO {
    @NotBlank(message = "Tên không được trống nha")
    @Size(min = 2, max = 50, message = "Tên từ 2-50 kí tự")
    private String name;

    private String description;

    private String country;

    private String website;
}
