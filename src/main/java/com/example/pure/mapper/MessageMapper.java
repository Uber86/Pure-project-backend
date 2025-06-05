package com.example.pure.mapper;

import com.example.pure.dto.MessageDto;
import com.example.pure.model.Message;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper (componentModel = MappingConstants.ComponentModel.SPRING)
public interface MessageMapper {

    MessageDto toDto(Message message);

    Message toEntity(MessageDto dto);

    List<MessageDto> toDtoList(List<Message> messages);

}
