package com.example.backen_springboot.services.auth;

import com.example.backen_springboot.dtos.UserDTO;
import com.example.backen_springboot.exception.ResourceNotFoundEx;
import com.example.backen_springboot.model.User;

public interface IAuthService {
    User createUser(UserDTO userDTO) throws Exception;
}
