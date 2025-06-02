package com.example.pure.model;

import com.example.pure.dto.Sex;
import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Class User  представляет модель пользователя
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    @Column(name= "sex")
    private Sex sex;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;

    public User() {
    }

    public User(Long id, String email, String password, String name, LocalDate birthday, Sex sex, Profile profile) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.profile = profile;
    }
}
