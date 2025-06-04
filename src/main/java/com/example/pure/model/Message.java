package com.example.pure.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Class Message модель обмена сообщениями между пользователями
 */
@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id", nullable = false)
    private Chat chat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id",nullable = false)
    private User sender;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "timestamp")
    private LocalDateTime localDateTime;

    @PrePersist
    public void prePersist() {
        localDateTime = LocalDateTime.now();
    }

    public Message() {
    }

    public Message(Long id, Chat chat, User sender,
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
