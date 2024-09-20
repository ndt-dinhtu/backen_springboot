package com.example.backen_springboot.service;

import com.example.backen_springboot.model.Color;
import com.example.backen_springboot.request.ColorDTO;

public interface IColorService {
    Color getColorByID(Long id);
    Color addColor(ColorDTO colorDTO);
    void deleteColor(Long id);
    Color updateColor(Long id, ColorDTO colorDTO);
}
