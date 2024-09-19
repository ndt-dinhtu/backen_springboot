package com.example.backen_springboot.service;

import com.example.backen_springboot.exception.OrderException;
import com.example.backen_springboot.model.Address;
import com.example.backen_springboot.model.Order;
import com.example.backen_springboot.model.User;

import java.util.List;

public interface OrderService {

    Order createOrder(User user, Address shippingAddress);

    Order findOrderById(Long orderId) throws OrderException;

    List<Order> usersOrderHistory(Long userId);

    Order placedOrder(Long orderId) throws OrderException;

    Order confirmedOrder(Long orderId) throws OrderException;

    Order shippedOrder(Long orderId) throws OrderException;

    Order deliveredOrder(Long orderId) throws OrderException;

    Order cancledOrder(Long orderId) throws OrderException;

    List<Order> getAllOrders();

    void deleteOrder(Long orderId) throws OrderException;
}
