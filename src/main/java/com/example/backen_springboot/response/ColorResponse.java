package com.example.backen_springboot.response;

import com.example.backen_springboot.model.Color;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColorResponse extends BaseResponse{
    private Long id;
    private String name;
    private String hexCode;
    public static ColorResponse fromColor(Color color){
        ColorResponse colorResponse = ColorResponse.builder()
                .id(color.getId())
                .name(color.getName())
                .hexCode(color.getHexCode())
                .build();
        colorResponse.setCreateAt(color.getCreateAt());
        colorResponse.setUpdateAt(color.getUpdateAt());
        return colorResponse;
    }

}
