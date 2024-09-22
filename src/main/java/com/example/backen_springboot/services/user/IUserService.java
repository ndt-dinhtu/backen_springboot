package com.example.backen_springboot.services.user;

import java.util.List;

import com.example.backen_springboot.model.User;
public interface IUserService {
    List<User> getAllUsers();
}
