package com.example.backen_springboot.service;

import com.example.backen_springboot.exception.ProductException;
import com.example.backen_springboot.model.Rating;
import com.example.backen_springboot.model.User;
import com.example.backen_springboot.request.RatingRequest;

import java.util.List;

public interface RatingService {
    Rating createRating(RatingRequest req, User user) throws ProductException;

    List<Rating> getProductsRating(Long productId);
}
