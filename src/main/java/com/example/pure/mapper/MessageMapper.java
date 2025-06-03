package com.example.pure.mapper;

import com.example.pure.dto.MessageDto;
import com.example.pure.model.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    MessageDto toDto(Message message);

    Message toEntity(MessageDto dto);

}
