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

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String name;

    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    @Column(name= "sex")
    private Sex sex;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;

    private Double latitude;

    private Double longitude;

    private boolean googleAccountLinked;

    public User() {
    }

    public User(Long id, String email, String password,
                String name, LocalDate birthday, Sex sex, Profile profile,
                Double latitude, Double longitude, boolean googleAccountLinked) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.profile = profile;
        this.latitude = latitude;
        this.longitude = longitude;
        this.googleAccountLinked = googleAccountLinked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public boolean isGoogleAccountLinked() {
        return googleAccountLinked;
    }

    public void setGoogleAccountLinked(boolean googleAccountLinked) {
        this.googleAccountLinked = googleAccountLinked;
    }
}
