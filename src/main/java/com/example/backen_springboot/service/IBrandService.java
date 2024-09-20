package com.example.backen_springboot.service;

import com.example.backen_springboot.model.Brand;
import com.example.backen_springboot.request.BrandDTO;

public interface IBrandService {
    Brand getBrandByID(Long id);
    Brand addBrand(BrandDTO brandDTO);
    void deleteBrand(Long id);
    Brand updateBrand(Long id, BrandDTO brandDTO);
}
