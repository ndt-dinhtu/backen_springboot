package com.example.backen_springboot.service;

import com.example.backen_springboot.exception.ProductException;
import com.example.backen_springboot.model.Product;
import com.example.backen_springboot.model.Review;
import com.example.backen_springboot.model.User;
import com.example.backen_springboot.repository.ProductRepository;
import com.example.backen_springboot.repository.ReviewRepository;
import com.example.backen_springboot.request.ReviewRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ReviewServiceImplementation implements ReviewService {

    private ReviewRepository reviewRepository;
    private ProductRepository productRepository;
    private ProductService productService;

    @Override
    public Review createReview(ReviewRequest req, User user) throws ProductException {
        Product product = productService.findProductById(req.getProductId());
        Review review = new Review();
        review.setUser(user);
        review.setProduct(product);
        review.setReview(req.getReview());
        review.setCreatedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReview(Long productId) {
        return reviewRepository.getAllProductsReview(productId);
    }
}
