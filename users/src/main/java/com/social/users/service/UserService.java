package com.social.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.users.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
}
