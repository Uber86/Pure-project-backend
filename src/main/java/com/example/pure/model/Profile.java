package com.example.pure.model;

import com.example.pure.dto.Search;
import com.example.pure.dto.Temptation;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

/**
 * Class Profile  расширенная модель user
 */
@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bio")
    private String bio;

    @ElementCollection
    @Column(name = "image")
    private List<String> image;

    @ElementCollection(targetClass = Temptation.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "preference")
    private Set<Temptation> temptations;

    @Enumerated(EnumType.STRING)
    @Column(name = "search")
    private Search search;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
