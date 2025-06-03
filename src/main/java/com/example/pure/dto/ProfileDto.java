package com.example.pure.dto;

import com.example.pure.model.User;
import jakarta.persistence.*;


import java.util.List;
import java.util.Set;

public class ProfileDto {

    private Long id;

    private String bio;

    private List<String> image;

    private Set<Temptation> temptation;

    private Search search;

    private User user;

    public ProfileDto() {
    }

    public ProfileDto(Long id, String bio, List<String> image,
                      Set<Temptation> temptation, Search search,
                      User user) {
        this.id = id;
        this.bio = bio;
        this.image = image;
        this.temptation = temptation;
        this.search = search;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }

    public Set<Temptation> getTemptation() {
        return temptation;
    }

    public void setTemptation(Set<Temptation> temptation) {
        this.temptation = temptation;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
