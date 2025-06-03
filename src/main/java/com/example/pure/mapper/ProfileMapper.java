package com.example.pure.mapper;

import com.example.pure.dto.ProfileDto;
import com.example.pure.model.Profile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    ProfileDto toDto(Profile profile);

    Profile toEntity(ProfileDto dto);
}
