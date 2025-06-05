package com.example.pure.controller;

import com.example.pure.mapper.UserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @PutMapping("/location")
    public ResponseEntity<UserDTO> updateLocation(@RequestBody LocationDTO locationDTO) {
        User updated = userService.updateLocation(locationDTO);
        return ResponseEntity.ok(userMapper.toDto(updated));
    }
}
}
