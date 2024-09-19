package com.example.backen_springboot.repository;

import com.example.backen_springboot.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
