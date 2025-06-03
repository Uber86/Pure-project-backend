package com.example.pure.dto;

import com.example.pure.model.Chat;
import com.example.pure.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class MessageDto {

    private Long id;

    private Chat chat;

    private User sender;

    private String content;

    private LocalDateTime localDateTime;

    public MessageDto() {
    }

    public MessageDto(Long id, Chat chat, User sender,
                      String content, LocalDateTime localDateTime) {
        this.id = id;
        this.chat = chat;
        this.sender = sender;
        this.content = content;
        this.localDateTime = localDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
