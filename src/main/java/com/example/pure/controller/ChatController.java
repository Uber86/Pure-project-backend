package com.example.pure.controller;

import com.example.pure.dto.ChatDto;
import com.example.pure.mapper.ChatMapper;
import com.example.pure.model.Chat;
import com.example.pure.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chats")
public class ChatController {

    private final ChatService chatService;
    private final ChatMapper chatMapper;

    public ChatController(ChatService chatService, ChatMapper chatMapper) {
        this.chatService = chatService;
        this.chatMapper = chatMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<ChatDto> createChat(@RequestParam Long otherUserId) {
        Chat chat = chatService.createChat(otherUserId);
        return ResponseEntity.ok(chatMapper.toDto(chat));
    }

    @GetMapping
    public ResponseEntity<List<ChatDto>> getMyChats() {
        List<Chat> chats = chatService.getMyChats();
        return ResponseEntity.ok(chatMapper.toDtoList(chats));
    }
}

