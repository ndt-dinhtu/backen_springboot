package com.example.backen_springboot.services.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.backen_springboot.dtos.UserDTO;
import com.example.backen_springboot.dtos.UserLoginDTO;
import com.example.backen_springboot.exception.ExistsHandlerException;

import com.example.backen_springboot.model.User;
import com.example.backen_springboot.respositories.UserRepository;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService{
    // Instance Fields
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User createUser(UserLoginDTO userLoginDTO) throws Exception {
        String email = userLoginDTO.getEmail();

        if(userRepository.existsByEmail(email)) {
            throw new ExistsHandlerException("Email đã tồn tại");
        }

        User user = User.builder()
                        .email(email)
                        .password(passwordEncoder.encode(userLoginDTO.getPassword()))
                        .role(userLoginDTO.getRole())
                        .build();
        return userRepository.save(user);
    }

   


}
