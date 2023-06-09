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
        User user = new User();
        user.setRole(1);
        updateUserFromDto(userDto, user);
        User savedUser = userRepository.save(user);
        return UserDto.fromUser(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            updateUserFromDto(userDto, user);
            User updatedUser = userRepository.save(user);
            return UserDto.fromUser(updatedUser);
        }
        return null;
    }

    @Override
    public void deleteUser(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        optionalUser.ifPresent(user -> userRepository.delete(user));

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
        user.setPassword(userDto.getPassword());
        user.setImage(userDto.getImage());
        user.setJob(userDto.getJob());
        user.setNumber(userDto.getNumber());
    }
}
