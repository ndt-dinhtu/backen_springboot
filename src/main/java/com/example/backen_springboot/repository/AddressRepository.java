package com.example.backen_springboot.repository;

import com.example.backen_springboot.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
