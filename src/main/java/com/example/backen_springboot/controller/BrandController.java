package com.example.backen_springboot.controller;

import com.example.backen_springboot.exception.ResourceNtFoundException;
import com.example.backen_springboot.model.Brand;
import com.example.backen_springboot.repository.BrandRepository;
import com.example.backen_springboot.request.BrandDTO;
import com.example.backen_springboot.response.ApiResponse;
import com.example.backen_springboot.response.BrandResponse;
import com.example.backen_springboot.service.BrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/brand")
public class BrandController {
    private final BrandService brandService;

    @PostMapping("")
    public ResponseEntity<ApiResponse> postBrand(@Valid @RequestBody BrandDTO brandDTO, BindingResult result){
        if (result.hasErrors()){
            List<String> errors = result.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage).toList();
            ApiResponse apiResponse = ApiResponse.builder()
                    .data(errors)
                    .message("Validation failed")
                    .status(HttpStatus.BAD_REQUEST.value())
                    .build();
            return ResponseEntity.badRequest().body(apiResponse);
        }
        ApiResponse apiResponse = ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Insert successfully" )
                .data(BrandResponse.fromBranch(brandService.addBrand(brandDTO)))
                .build();
        return ResponseEntity.ok().body(apiResponse);

    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateBrand(@PathVariable Long id, @Valid @RequestBody BrandDTO brandDTO, BindingResult result){
        if (result.hasErrors()){
            List<String> errors = result.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage).toList();
            ApiResponse apiResponse = ApiResponse.builder()
                    .status(HttpStatus.BAD_REQUEST.value())
                    .message("Validation failed")
                    .data(errors)
                    .build();
            return ResponseEntity.badRequest().body(apiResponse);
        }
        Brand brand = brandService.updateBrand(id, brandDTO);
        if(brand == null){
            throw new ResourceNtFoundException("Student không tìm thấy với id: "+id);
        }
        ApiResponse apiResponse =ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Update successfully" )
                .data(BrandResponse.fromBranch(brand))
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable ("id") Long id){

        Brand student = brandService.getBrandByID(id);
        if (student == null){
            throw new ResourceNtFoundException("Student không tìm thấy id: "+ id);
        }
        brandService.deleteBrand(id);
        ApiResponse apiResponse = ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .data(id)
                .message("Delete thành công")
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }

}
