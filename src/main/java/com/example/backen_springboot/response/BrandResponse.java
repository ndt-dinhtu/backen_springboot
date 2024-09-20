package com.example.backen_springboot.response;

import com.example.backen_springboot.model.Brand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrandResponse extends BaseResponse{
    private Long id;
    private String name;
    private String description;
    private String country;
    private String website;

    public static BrandResponse fromBranch(Brand brand){
        BrandResponse brandResponse = BrandResponse.builder()
                .id(brand.getId())
                .name(brand.getName())
                .description(brand.getDescription())
                .country(brand.getCountry())
                .website(brand.getWebsite())
                .build();
        brandResponse.setCreateAt(brand.getCreateAt());
        brandResponse.setUpdateAt(brand.getUpdateAt());
        return brandResponse;
    }
}
