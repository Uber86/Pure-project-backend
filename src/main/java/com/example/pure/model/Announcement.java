package com.example.pure.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

/**
 * Class Announcement модель ленты объявлении
 */
@Entity
@Table(name = "announcements")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User users;

    private String title;

    private String description;

    private Timestamp createdAt;
}
