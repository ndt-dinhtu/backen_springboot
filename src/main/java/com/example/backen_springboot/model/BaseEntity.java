package com.example.backen_springboot.model;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@MappedSuperclass
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    @JsonProperty(namespace = "created_at")
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @JsonProperty(namespace = "updated_at")
    private LocalDateTime updatedAt;
}
