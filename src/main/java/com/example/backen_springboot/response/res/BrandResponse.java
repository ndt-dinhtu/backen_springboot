package com.example.backen_springboot.response.res;

import com.example.backen_springboot.model.Brand;
import com.example.backen_springboot.response.BaseResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BrandResponse extends BaseResponse{
    private Long id;
    private String name;
    private String country;
    private String description;
    private String website;

    public static BrandResponse brandResponse(Brand brand) {
        BrandResponse brandResponse = BrandResponse.builder()
                                                    .name(brand.getName())
                                                    .description(brand.getDescription())
                                                    .country(brand.getCountry())
                                                    .website(brand.getWebsite())
                                                    .build();
        brandResponse.setCreatedAt(brand.getCreatedAt());
        brandResponse.setUpdatedAt(brand.getUpdatedAt());
        return brandResponse;
    }
}
