package com.example.backen_springboot.service;

import com.example.backen_springboot.model.Size;
import com.example.backen_springboot.request.SizeDTO;

public interface ISizeService {
    Size getSizeByID(Long id);
    Size addSize(SizeDTO brandDTO);
    void deleteSize(Long id);
    Size updateSize(Long id, SizeDTO sizeDTO);
}
