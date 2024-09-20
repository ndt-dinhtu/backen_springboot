package com.example.backen_springboot.service;

import com.example.backen_springboot.model.Color;
import com.example.backen_springboot.repository.ColorRepository;
import com.example.backen_springboot.request.ColorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ColorService implements IColorService{
    private final ColorRepository colorRepository;
    @Override
    public Color getColorByID(Long id) {
        return colorRepository.findById(id).orElse(null);
    }

    @Override
    public Color addColor(ColorDTO colorDTO) {
        Color color = Color.builder()
                .name(colorDTO.getName())
                .hexCode(colorDTO.getHexCode())
                .build();
        return colorRepository.save(color);
    }

    @Override
    public void deleteColor(Long id) {
        colorRepository.deleteById(id);
    }

    @Override
    public Color updateColor(Long id, ColorDTO colorDTO) {
        Color color = getColorByID(id);
        color.setName(colorDTO.getName());
        color.setHexCode(colorDTO.getHexCode());
        return colorRepository.save(color);
    }
}
