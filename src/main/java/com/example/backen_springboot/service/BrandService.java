package com.example.backen_springboot.service;

import com.example.backen_springboot.model.Brand;
import com.example.backen_springboot.repository.BrandRepository;
import com.example.backen_springboot.request.BrandDTO;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BrandService implements IBrandService{
    private final BrandRepository brandRepository;
    @Override
    public Brand getBrandByID(Long id) {
        return brandRepository.findById(id).orElse(null);
    }

    @Override
    public Brand addBrand(BrandDTO brandDTO) {
        Brand newBrand = Brand.builder()
                .name(brandDTO.getName())
                .description(brandDTO.getDescription())
                .country(brandDTO.getCountry())
                .website(brandDTO.getWebsite())
                .build();
        return brandRepository.save(newBrand);
    }

    @Override
    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }

    @Override
    public Brand updateBrand(Long id, BrandDTO brandDTO) {
        Brand brand = getBrandByID(id);
        brand.setName(brandDTO.getName());
        brand.setDescription(brandDTO.getDescription());
        brand.setCountry(brandDTO.getCountry());
        brand.setWebsite(brandDTO.getWebsite());
        return brandRepository.save(brand);
    }
}
