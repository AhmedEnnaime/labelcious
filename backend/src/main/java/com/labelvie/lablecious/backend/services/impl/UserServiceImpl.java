package com.labelvie.lablecious.backend.services.impl;

import com.labelvie.lablecious.backend.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserService userService;

    public UserServiceImpl(UserService userService) {
        this.userService = userService;
    }
}
