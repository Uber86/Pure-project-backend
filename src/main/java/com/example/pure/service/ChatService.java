package com.example.pure.service;

import com.example.pure.dto.ChatDto;
import com.example.pure.dto.MessageDto;
import com.example.pure.mapper.ChatMapper;
import com.example.pure.model.Chat;
import com.example.pure.model.Message;
import com.example.pure.model.User;
import com.example.pure.repository.ChatRepository;
import com.example.pure.repository.MessageRepository;
import com.example.pure.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class ChatService {

    private final ChatRepository chatRepository;
    private final SecurityService securityService;
    private final UserRepository userRepository;

    public ChatService(ChatRepository chatRepository, SecurityService securityService, UserRepository userRepository) {
        this.chatRepository = chatRepository;
        this.securityService = securityService;
        this.userRepository = userRepository;
    }

    public Chat createChat(Long otherUserId) {
        Long currentUserId = securityService.getCurrentUserId();
        User userCurrent = userRepository.findById(currentUserId)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        User userOther = userRepository.findById(otherUserId)
                .orElseThrow(() -> new RuntimeException("Собеседник не найден"));
        Chat chat = new Chat();
        chat.setParticipants(Set.of(userCurrent, userOther));
        return chatRepository.save(chat);
    }

    public List<Chat> getMyChats() {
        Long currentUserId = securityService.getCurrentUserId();
        return chatRepository.findByParticipantsContaining(currentUserId);
    }
}

