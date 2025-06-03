package com.example.pure.mapper;

import com.example.pure.dto.AnnouncementDto;
import com.example.pure.model.Announcement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnnouncementMapper {

    AnnouncementDto toDto(Announcement announcement);

    Announcement toEntity(AnnouncementDto announcement);
}
