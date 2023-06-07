package com.labelvie.lablecious.backend.services.impl;

import com.labelvie.lablecious.backend.repository.UserRepository;
import com.labelvie.lablecious.backend.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
