package com.example.pure.service;

import com.example.pure.dto.MessageDto;
import com.example.pure.mapper.MessageMapper;
import com.example.pure.model.Chat;
import com.example.pure.model.Message;
import com.example.pure.model.User;
import com.example.pure.repository.ChatRepository;
import com.example.pure.repository.MessageRepository;
import com.example.pure.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final SecurityService securityService;
    private final ChatRepository chatRepository;
    private final MessageMapper messageMapper;
    private final UserRepository userRepository;

    public MessageService(MessageRepository messageRepository,
                          SecurityService securityService,
                          ChatRepository chatRepository,
                          MessageMapper messageMapper, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.securityService = securityService;
        this.chatRepository = chatRepository;
        this.messageMapper = messageMapper;
        this.userRepository = userRepository;
    }

    private void checkUserAccess(Long chatId) {
        Long userId = securityService.getCurrentUserId();
        Chat chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new EntityNotFoundException("Chat not found"));
        if (!chat.getParticipants().contains(userId)) {
            throw new AccessDeniedException("User is not participant of this chat");
        }
    }

    public List<MessageDto> getMessages(Long chatId) {
        checkUserAccess(chatId);
        List<Message> messages = messageRepository.findByChatIdOrderByLocalDateTimeAsc(chatId);
        return messageMapper.toDtoList(messages);
    }

    public MessageDto sendMessage(Long chatId, MessageDto dto) {
        checkUserAccess(chatId);
        Message message = messageMapper.toEntity(dto);
        Chat chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new RuntimeException("Чат не найден"));
        User user = userRepository.findById(securityService.getCurrentUserId())
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        message.setChat(chat);
        message.setSender(user);
        message.setLocalDateTime(LocalDateTime.now());
        Message saved = messageRepository.save(message);
        return messageMapper.toDto(saved);
    }
}
