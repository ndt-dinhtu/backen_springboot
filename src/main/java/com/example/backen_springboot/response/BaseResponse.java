package com.example.backen_springboot.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {

    @JsonProperty(namespace = "created_at")
    private LocalDateTime createdAt;

    @JsonProperty(namespace = "updated_at")
    private LocalDateTime updatedAt;
}
