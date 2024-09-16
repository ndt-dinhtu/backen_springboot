package com.example.backen_springboot.service;

import com.example.backen_springboot.exception.UserException;
import com.example.backen_springboot.model.User;

public interface UserService {
    public User findUserById(Long userId) throws UserException;
    public User findUserProfileByJwt(String jwt) throws UserException;
}
