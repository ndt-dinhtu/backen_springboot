package com.example.backen_springboot.repository;

import com.example.backen_springboot.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long>{
}
