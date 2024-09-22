package com.example.backen_springboot.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backen_springboot.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{
    
}
