package com.example.pure.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * Class Chat модель чата с пользователями
 */
@Entity
@Table(name = "chats")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private List<Message> message;

}
