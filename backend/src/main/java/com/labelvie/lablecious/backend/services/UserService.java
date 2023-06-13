package com.labelvie.lablecious.backend.services;

import com.labelvie.lablecious.backend.models.dto.UserDto;
import com.labelvie.lablecious.backend.models.entity.User;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();

    UserDto getUserById(long id);

    UserDto saveUser(UserDto userDto);

    UserDto updateUser(UserDto userDto, long id);

    void deleteUser(long id);

    UserDto getUserByEmail(String email);

    User findOrFail(long id);
}
