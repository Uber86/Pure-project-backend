package com.example.pure.service;

import com.example.pure.dto.UserDto;
import com.example.pure.mapper.UserMapper;
import com.example.pure.model.User;
import com.example.pure.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    public UserService(UserRepository userRepository, UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        return mapper.toDto(user);
    }

    /** Геолокация
    public UserDto getUserLocation(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        return new UserDto(user.getLatitude(), user.getLongitude());
    }
     **/

}
