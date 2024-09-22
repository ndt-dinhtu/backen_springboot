package com.example.backen_springboot.services.brand;

import com.example.backen_springboot.dtos.BrandDTO;
import com.example.backen_springboot.model.Brand;
import com.example.backen_springboot.response.res.BrandResponse;

public interface IBrandService {
    Brand addBrand(BrandDTO brandDTO);
}
