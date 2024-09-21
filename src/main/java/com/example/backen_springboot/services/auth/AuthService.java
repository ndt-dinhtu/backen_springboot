package com.example.backen_springboot.services.auth;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.backen_springboot.configuration.components.JwtTokenUtil;
import com.example.backen_springboot.dtos.UserLoginDTO;
import com.example.backen_springboot.exception.ExistsHandlerException;
import com.example.backen_springboot.exception.ResourceNotFoundEx;
import com.example.backen_springboot.model.User;
import com.example.backen_springboot.respositories.UserRepository;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService{
    // Instance Fields
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

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

    @Override
    public String login(UserLoginDTO userLoginDTO) throws Exception {
        
        User user = userRepository.findByEmail(userLoginDTO.getEmail())
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Kiểm tra mật khẩu
        if (!passwordEncoder.matches(userLoginDTO.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // Nếu xác thực thành công, tạo JWT
        return jwtTokenUtil.generateToken(user);
    }

    
   


}
