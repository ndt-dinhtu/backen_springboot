package com.example.backen_springboot.repository;

import com.example.backen_springboot.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Long> {
}
