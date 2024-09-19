package com.example.backen_springboot.service;

import com.example.backen_springboot.exception.ProductException;
import com.example.backen_springboot.model.Review;
import com.example.backen_springboot.model.User;
import com.example.backen_springboot.request.ReviewRequest;

import java.util.List;

public interface ReviewService {
    public Review createReview(ReviewRequest req, User user) throws ProductException;
    public List<Review> getAllReview(Long productId);
}
