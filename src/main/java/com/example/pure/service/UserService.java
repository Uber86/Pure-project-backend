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
    private final SecurityService securityService;

    public UserService(UserRepository userRepository, UserMapper mapper, SecurityService securityService) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.securityService = securityService;
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        return mapper.toDto(user);
    }

    public UserDto updateLocation(Double latitude, Double longitude) {
        User user = securityService.getCurrentUser();
        user.setLatitude(latitude);
        user.setLongitude(longitude);
        User savedUser = userRepository.save(user);
        return mapper.toDto(savedUser);
    }

}
