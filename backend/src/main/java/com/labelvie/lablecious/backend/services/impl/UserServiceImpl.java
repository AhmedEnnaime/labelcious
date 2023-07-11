package com.labelvie.lablecious.backend.services.impl;

import com.labelvie.lablecious.backend.exceptions.handler.ResourceNotFoundException;
import com.labelvie.lablecious.backend.models.dto.UserDto;
import com.labelvie.lablecious.backend.models.entity.User;
import com.labelvie.lablecious.backend.repository.UserRepository;
import com.labelvie.lablecious.backend.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        return UserDto.fromUsers(users);
    }

    @Override
    public UserDto getUserById(long id) {
        return UserDto.fromUser(this.findOrFail(id));
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        userDto.setRole(1);
        User user = userDto.toUser();
        return UserDto.fromUser(userRepository.save(user));
    }

    @Override
    public UserDto updateUser(UserDto userDto, long id) {
        userDto.setRole(1);
        userDto.setId(this.findOrFail(id).getId());
        User user = userDto.toUser();
        return UserDto.fromUser(userRepository.save(user));
    }

    @Override
    public void deleteUser(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        optionalUser.ifPresent(user -> userRepository.delete(user));

    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return UserDto.fromUser(user);
        } else {
            throw new ResourceNotFoundException("User not found with email: " + email);
        }
    }


    @Override
    public User findOrFail(long id) {
        return userRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("The User with id " + id + " does not exist !"));
    }

    private void updateUserFromDto(UserDto userDto, User user) {
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setImage(userDto.getImage());
        user.setJob(userDto.getJob());
        user.setNumber(userDto.getNumber());
    }
}
