package com.unit.testing.service;

import com.unit.testing.dto.UserDto;
import com.unit.testing.exception.UserNotFoundException;
import com.unit.testing.mapper.UserMapper;
import com.unit.testing.model.UserEntity;
import com.unit.testing.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository,
                           UserMapper userMapper
    ) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity user = userMapper.dtoToEntity(userDto);
        UserEntity savedUser = userRepository.save(user);
        return userMapper.entityToDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException("User not found with ID : " + userId));

        return userMapper.entityToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException("User not found with ID : " + userId));

        user.setUserFullName(userDto.getUserFullName());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());

        return userMapper.entityToDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException("User not found with ID : " + userId));
        userRepository.delete(user);
    }
}
