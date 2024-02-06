package com.springboot.demo.springbootdemo1.service.impl;

import com.springboot.demo.springbootdemo1.exception.APIException;
import com.springboot.demo.springbootdemo1.model.User;
import com.springboot.demo.springbootdemo1.payload.LoginDto;
import com.springboot.demo.springbootdemo1.payload.RegisterDto;
import com.springboot.demo.springbootdemo1.repository.UserRepository;
import com.springboot.demo.springbootdemo1.security.JwtTokenProvider;
import com.springboot.demo.springbootdemo1.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        return token;
    }

    @Override
    public String register(RegisterDto registerDto) {
        //check username exists
        if(userRepository.existsByUsername(registerDto.getUsername())) {
            throw new APIException(HttpStatus.BAD_REQUEST, "Username already exists!");
        }
        //check email exists
        if(userRepository.existsByEmail(registerDto.getUsername())) {
            throw new APIException(HttpStatus.BAD_REQUEST, "Email already exists!");
        }

        User newUser = new User();
        newUser.setName(registerDto.getName());
        newUser.setUsername(registerDto.getUsername());
        newUser.setEmail(registerDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        userRepository.save(newUser);

        return "Success - user has been registered!";
    }
}
