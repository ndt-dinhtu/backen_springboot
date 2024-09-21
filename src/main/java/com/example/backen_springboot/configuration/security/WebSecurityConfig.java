package com.example.backen_springboot.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.backen_springboot.configuration.filters.JwtTokenFilter;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import lombok.AllArgsConstructor;


@EnableWebMvc
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig {
    private final UserDetailsService userDetailsService;
    private final JwtTokenFilter jwtTokenFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Filter trước khi xác thực
            .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth

                // Các request ko yêu cầu xác thực
                // mẫu pattern: String.format("%s/users/refresh-token", apiPrefix)
                .requestMatchers(HttpMethod.POST,
                    "api/v2/auth/register",
                    "api/v2/auth/login"
                ).permitAll()
                // .requestMatchers(HttpMethod.GET,
                //     "api/v2/auth",
                //     "api/v2/auth/hi"
                // ).permitAll()
                // .requestMatchers(HttpMethod.DELETE,
                //     ""
                // ).permitAll()
                // .requestMatchers(HttpMethod.PUT,
                //     ""
                // ).permitAll()

                // Các request yêu cầu xác thực admin
                // .requestMatchers(HttpMethod.POST,
                //     ""
                // ).hasRole("ADMIN")
                // .requestMatchers(HttpMethod.GET,
                //     ""
                // ).hasRole("ADMIN")
                // .requestMatchers(HttpMethod.DELETE,
                //     ""
                // ).hasRole("ADMIN")
                // .requestMatchers(HttpMethod.PUT,
                //     ""
                // ).hasRole("ADMIN")

                // Còn lại đều phải xác thực ( kể cả user hay admin)
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
