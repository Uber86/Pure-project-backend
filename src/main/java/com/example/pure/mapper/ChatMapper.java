package com.example.pure.mapper;

import com.example.pure.dto.ChatDto;
import com.example.pure.model.Chat;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper (componentModel = MappingConstants.ComponentModel.SPRING)
public interface ChatMapper {

    ChatDto toDto(Chat chat);

    Chat toEntity(ChatDto dto);

    List<ChatDto> toDtoList(List<Chat> chatList);




}
