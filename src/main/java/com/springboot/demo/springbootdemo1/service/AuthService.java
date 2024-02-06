package com.springboot.demo.springbootdemo1.service;

import com.springboot.demo.springbootdemo1.payload.LoginDto;
import com.springboot.demo.springbootdemo1.payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
}
