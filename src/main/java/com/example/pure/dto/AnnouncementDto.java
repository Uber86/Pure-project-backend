package com.example.pure.dto;

import com.example.pure.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AnnouncementDto {

    private Long id;

    private User users;

    private String title;

    private String description;

    private LocalDateTime createdAt;

    public AnnouncementDto() {
    }

    public AnnouncementDto(Long id, User users, String title,
                           String description, LocalDateTime createdAt) {
        this.id = id;
        this.users = users;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
