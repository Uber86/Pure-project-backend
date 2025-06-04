package com.example.pure.mapper;

import com.example.pure.dto.MessageDto;
import com.example.pure.model.Message;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper (componentModel = MappingConstants.ComponentModel.SPRING)
public interface MessageMapper {

    MessageDto toDto(Message message);

    Message toEntity(MessageDto dto);

}
