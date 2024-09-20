package com.example.backen_springboot.repository;

import com.example.backen_springboot.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepository extends JpaRepository<Size, Long> {
}
