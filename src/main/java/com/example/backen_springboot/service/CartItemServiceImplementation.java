package com.example.backen_springboot.service;

import com.example.backen_springboot.exception.CartItemException;
import com.example.backen_springboot.exception.UserException;
import com.example.backen_springboot.model.Cart;
import com.example.backen_springboot.model.CartItem;
import com.example.backen_springboot.model.Product;
import com.example.backen_springboot.repository.CartItemRepository;
import com.example.backen_springboot.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartItemServiceImplementation implements CartItemService {

    private CartItemRepository cartItemRepository;
    private UserService userService;
    private CartRepository cartRepository;

    @Override
    public CartItem createCartItem(CartItem cartItem) {
        return null;
    }

    @Override
    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException {
        return null;
    }

    @Override
    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) {
        return null;
    }

    @Override
    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException {

    }

    @Override
    public CartItem findCartItemById(Long cartItemId) throws CartItemException {
        return null;
    }
}
