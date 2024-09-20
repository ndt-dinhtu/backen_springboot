package com.example.backen_springboot.controller;

import com.example.backen_springboot.exception.ResourceNtFoundException;
import com.example.backen_springboot.model.Brand;
import com.example.backen_springboot.model.Size;
import com.example.backen_springboot.request.BrandDTO;
import com.example.backen_springboot.request.SizeDTO;
import com.example.backen_springboot.response.ApiResponse;
import com.example.backen_springboot.response.BrandResponse;
import com.example.backen_springboot.response.SizeResponse;
import com.example.backen_springboot.service.BrandService;
import com.example.backen_springboot.service.SizeService;
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
@RequestMapping("/size")
public class SizeController {
    private final SizeService sizeService;

    @PostMapping("")
    public ResponseEntity<ApiResponse> postSize(@Valid @RequestBody SizeDTO sizeDTO, BindingResult result){
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
                .data(SizeResponse.fromSize(sizeService.addSize(sizeDTO)))
                .build();
        return ResponseEntity.ok().body(apiResponse);

    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateSize(@PathVariable Long id, @Valid @RequestBody SizeDTO sizeDTO, BindingResult result){
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
        Size size = sizeService.updateSize(id, sizeDTO);
        if(size == null){
            throw new ResourceNtFoundException("Size không tìm thấy với id: "+id);
        }
        ApiResponse apiResponse =ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Update successfully" )
                .data(SizeResponse.fromSize(size))
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteSize(@PathVariable ("id") Long id){

        Size size = sizeService.getSizeByID(id);
        if (size == null){
            throw new ResourceNtFoundException("Size không tìm thấy id: "+ id);
        }
        sizeService.deleteSize(id);
        ApiResponse apiResponse = ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .data(id)
                .message("Delete thành công")
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }

}
