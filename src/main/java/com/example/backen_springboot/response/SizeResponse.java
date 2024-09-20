package com.example.backen_springboot.response;


import com.example.backen_springboot.model.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SizeResponse extends BaseResponse{
    private Long id;
    private String name;
    private int quantity;

    public static SizeResponse fromSize(Size size){
        SizeResponse sizeResponse = SizeResponse.builder()
                .id(size.getId())
                .name(size.getName())
                .quantity(size.getQuantity())
                .build();
        sizeResponse.setUpdateAt(size.getUpdateAt());
        sizeResponse.setCreateAt(size.getCreateAt());
        return sizeResponse;
    }
}
