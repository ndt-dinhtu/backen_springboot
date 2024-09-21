package com.example.backen_springboot.model;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "brand")
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class Brand extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên không được để trống")
    private String name;

    @Lob
    @NotBlank(message = "Mô tả không được để trống")
    private String description;

    @NotBlank(message = "Nơi sản xuất không được để trống")
    private String country;

    @URL(message = "Địa chỉ website không hợp lệ")
    @NotBlank(message = "Trang web công ty brand không được để trống")
    private String website;
    
}
