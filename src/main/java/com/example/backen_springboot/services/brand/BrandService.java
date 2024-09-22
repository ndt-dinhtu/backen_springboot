package com.example.backen_springboot.services.brand;

import org.springframework.stereotype.Service;

import com.example.backen_springboot.dtos.BrandDTO;
import com.example.backen_springboot.model.Brand;
import com.example.backen_springboot.respositories.BrandRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrandService implements IBrandService{
    // Instance fields
    private final BrandRepository brandRepository;

    @Override
    public Brand addBrand(BrandDTO brandDTO) {
        return brandRepository.save(
            Brand.builder()
                .name(brandDTO.getName())
                .country(brandDTO.getCountry())
                .description(brandDTO.getDescription())
                .website(brandDTO.getWebsite())
                .build()
        );
    }

    

    
}
