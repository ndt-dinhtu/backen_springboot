package com.example.backen_springboot.controller;

import com.example.backen_springboot.exception.ResourceNtFoundException;
import com.example.backen_springboot.model.Color;
import com.example.backen_springboot.request.ColorDTO;
import com.example.backen_springboot.response.ApiResponse;
import com.example.backen_springboot.response.ColorResponse;
import com.example.backen_springboot.service.ColorService;
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
@RequestMapping("/color")
public class ColorController {
    private final ColorService colorService;

    @PostMapping("")
    public ResponseEntity<ApiResponse> postColor(@Valid @RequestBody ColorDTO colorDTO, BindingResult result){
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
                .data(ColorResponse.fromColor(colorService.addColor(colorDTO)))
                .build();
        return ResponseEntity.ok().body(apiResponse);

    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateColor(@PathVariable Long id, @Valid @RequestBody ColorDTO colorDTO, BindingResult result){
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
        Color color = colorService.updateColor(id, colorDTO);
        if(color == null){
            throw new ResourceNtFoundException("Color không tìm thấy với id: "+id);
        }
        ApiResponse apiResponse =ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Update successfully" )
                .data(ColorResponse.fromColor(color))
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteColor(@PathVariable ("id") Long id){

        Color student = colorService.getColorByID(id);
        if (student == null){
            throw new ResourceNtFoundException("Color không tìm thấy id: "+ id);
        }
        colorService.deleteColor(id);
        ApiResponse apiResponse = ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .data(id)
                .message("Delete thành công")
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }

}
