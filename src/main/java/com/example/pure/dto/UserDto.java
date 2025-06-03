package com.example.pure.dto;

import com.example.pure.model.Profile;
import jakarta.persistence.*;

import java.time.LocalDate;

public class UserDto {

    private Long id;

    private String email;

    private String password;

    private String name;

    private LocalDate birthday;

    private Sex sex;

    private Profile profile;

    public UserDto() {
    }

    public UserDto(Long id, String email, String password,
                   String name, LocalDate birthday, Sex sex,
                   Profile profile) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.profile = profile;
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
}
