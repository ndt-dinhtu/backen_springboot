package com.example.backen_springboot.service;

import com.example.backen_springboot.exception.ProductException;
import com.example.backen_springboot.model.Product;
import com.example.backen_springboot.request.CreateProductRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product createProduct(CreateProductRequest req);

    String deleteProduct(Long productid) throws ProductException;

    Product updateProduct(Long productid, Product req) throws ProductException;

    Product findProductById(Long id) throws ProductException;

    List<Product> findProductByCategory(String category);

    Page<Product> getAllProduct(String category, List<String> colors, List<String> sizes,
                                Integer minPrice, Integer maxPrice, Integer minDiscount,
                                String sort, String stock, Integer pageNumber, Integer pageSize);
}
