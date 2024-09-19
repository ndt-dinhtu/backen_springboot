package com.example.backen_springboot.service;

import com.example.backen_springboot.exception.ProductException;
import com.example.backen_springboot.model.Cart;
import com.example.backen_springboot.model.User;
import com.example.backen_springboot.repository.CartRepository;
import com.example.backen_springboot.request.AddItemRequest;

public class CartServiceImplementation implements CartService{

    private CartRepository cartRepository;
    private CartItemService cartItemService;

    @Override
    public Cart createCart(User user) {
        return null;
    }

    @Override
    public String addCartItem(Long userId, AddItemRequest req) throws ProductException {
        return "";
    }

    @Override
    public Cart findUserCart(Long userId) {
        return null;
    }
}
