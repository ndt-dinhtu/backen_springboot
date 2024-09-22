package com.example.backen_springboot.services.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backen_springboot.model.User;
import com.example.backen_springboot.respositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    
}
