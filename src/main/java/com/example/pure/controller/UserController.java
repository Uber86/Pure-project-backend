package com.example.pure.controller;

import com.example.pure.dto.UserDto;
import com.example.pure.mapper.UserMapper;
import com.example.pure.model.User;
import com.example.pure.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/location")
    public ResponseEntity<UserDto> updateLocation(@RequestBody Double latitude,@RequestBody Double longitude) {
        return ResponseEntity.ok(userService.updateLocation(latitude, longitude));
    }

}
