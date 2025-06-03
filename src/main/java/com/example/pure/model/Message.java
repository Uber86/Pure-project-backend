package com.example.pure.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

/**
 * Class Message модель сообщения в чате
 */
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Chat chat;

    private User sender;

    private String content;

    private Timestamp timestamp;
}
