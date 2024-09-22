package com.example.backen_springboot.controllers.admin;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backen_springboot.dtos.BrandDTO;
import com.example.backen_springboot.model.Brand;
import com.example.backen_springboot.response.ApiResponse;
import com.example.backen_springboot.response.ResponseData;
import com.example.backen_springboot.response.res.BrandResponse;
import com.example.backen_springboot.services.brand.BrandService;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("${api.prefix}/v1/brand")
@RequiredArgsConstructor
public class BrandAdminController {
    private final BrandService brandService;

    @PostMapping
    public ResponseEntity<ApiResponse> addBrand(@Valid @RequestBody BrandDTO brandDTO, BindingResult result) {
        System.out.println(brandDTO.toString());
        if(result.hasErrors()) {
            return ResponseData.responseBindingResult(result);
        }

        Brand brand = brandService.addBrand(brandDTO);

        return ResponseData.responseOk(
            "Thêm thành công brand", BrandResponse.fromBrand(brand)
        );
        
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getHello () {
        return ResponseData.responseOk("Test success", "Hello");
    }
}
