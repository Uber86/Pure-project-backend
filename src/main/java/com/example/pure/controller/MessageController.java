package com.example.pure.controller;

import com.example.pure.dto.MessageDto;
import com.example.pure.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chats/{chatId}/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public ResponseEntity<List<MessageDto>> getMessages(@PathVariable Long chatId) {
        return ResponseEntity.ok(messageService.getMessages(chatId));
    }

    @PostMapping
    public ResponseEntity<MessageDto> sendMessage(@PathVariable Long chatId, @RequestBody MessageDto dto) {
        return ResponseEntity.ok(messageService.sendMessage(chatId, dto));
    }
}
}
