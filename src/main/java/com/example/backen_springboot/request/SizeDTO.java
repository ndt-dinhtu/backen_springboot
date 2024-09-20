package com.example.backen_springboot.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SizeDTO {
    @Size(min = 1, max = 5, message = "Size có tử 1 đến 5 kí tự")
    private String name;

    private int quantity;
}
