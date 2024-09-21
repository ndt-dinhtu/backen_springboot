package com.example.backen_springboot.services.auth;


import com.example.backen_springboot.dtos.UserLoginDTO;
import com.example.backen_springboot.model.User;

public interface IAuthService {
    User createUser(UserLoginDTO userLoginDTO) throws Exception;
    String login(UserLoginDTO userLoginDTO) throws Exception;
}
