package com.example.pure.mapper;

import com.example.pure.dto.UserDto;
import com.example.pure.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDto dto);

    UserDto toDto(User user);
}
