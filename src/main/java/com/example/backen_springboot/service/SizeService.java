package com.example.backen_springboot.service;

import com.example.backen_springboot.model.Size;
import com.example.backen_springboot.repository.SizeRepository;
import com.example.backen_springboot.request.SizeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SizeService implements ISizeService{
    private final SizeRepository sizeRepository;
    @Override
    public Size getSizeByID(Long id) {
        return sizeRepository.findById(id).orElse(null);
    }

    @Override
    public Size addSize(SizeDTO sizeDTO) {
        Size size = Size.builder()
                .name(sizeDTO.getName())
                .quantity(sizeDTO.getQuantity())
                .build();
        return sizeRepository.save(size);
    }

    @Override
    public void deleteSize(Long id) {
        sizeRepository.deleteById(id);
    }

    @Override
    public Size updateSize(Long id, SizeDTO sizeDTO) {
        Size size = getSizeByID(id);
        size.setName(sizeDTO.getName());
        size.setQuantity(sizeDTO.getQuantity());
        return sizeRepository.save(size);
    }
}
