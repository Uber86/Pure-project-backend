package com.example.pure.dto;

import com.example.pure.model.Message;
import com.example.pure.model.User;

import java.util.List;
import java.util.Set;

public class ChatDto {

    private Long id;

    private Set<User> participants;

    private List<Message> message;

    public ChatDto() {
    }

    public ChatDto(Long id, Set<User> participants, List<Message> message) {
        this.id = id;
        this.participants = participants;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<User> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<User> participants) {
        this.participants = participants;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }
}
