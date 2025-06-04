package com.example.pure.mapper;

import com.example.pure.dto.ChatDto;
import com.example.pure.model.Chat;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper (componentModel = MappingConstants.ComponentModel.SPRING)
public interface ChatMapper {

    ChatDto toDto(Chat chat);

    Chat toEntity(ChatDto dto);


}
