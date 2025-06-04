package com.example.pure.mapper;

import com.example.pure.dto.UserDto;
import com.example.pure.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper (componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User toEntity(UserDto dto);

    UserDto toDto(User user);
}
