package com.example.backen_springboot.service;

import com.example.backen_springboot.exception.CartItemException;
import com.example.backen_springboot.exception.UserException;
import com.example.backen_springboot.model.Cart;
import com.example.backen_springboot.model.CartItem;
import com.example.backen_springboot.model.Product;

public interface CartItemService {

    CartItem createCartItem(CartItem cartItem);

    CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException;

    CartItem isCartItemExist(Cart cart, Product product, String size, Long userId);

    void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException;

    CartItem findCartItemById(Long cartItemId) throws CartItemException;
}
