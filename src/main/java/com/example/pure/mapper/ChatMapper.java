package com.example.pure.mapper;

import com.example.pure.dto.ChatDto;
import com.example.pure.model.Chat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    ChatDto toDto(Chat chat);

    Chat toEntity(ChatDto dto);


}
