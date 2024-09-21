package com.example.backen_springboot.services.auth;

import org.springframework.stereotype.Service;

import com.example.backen_springboot.dtos.UserDTO;
import com.example.backen_springboot.exception.ResourceNotFoundEx;
import com.example.backen_springboot.model.User;
import com.example.backen_springboot.respositories.UserRepository;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService{
    // Instance Fields
    private final UserRepository userRepository;

    @Override
    public User createUser(UserDTO userDTO) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }

   


}
