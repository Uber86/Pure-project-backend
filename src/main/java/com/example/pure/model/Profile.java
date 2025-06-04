package com.example.pure.model;

import com.example.pure.dto.Search;
import com.example.pure.dto.Temptation;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * Class Profile  расширенная модель user
 */
@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;

    @ElementCollection
    @CollectionTable(name = "profile_image",
            joinColumns = @JoinColumn(name = "profile_id"))
    @Column(name = "image_url")
    private List<String> image;

    @ElementCollection(targetClass = Temptation.class)
    @CollectionTable(name = "profile_temptation",
            joinColumns = @JoinColumn(name = "profile_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "temptation")
    private Set<Temptation> temptation;

    @Enumerated(EnumType.STRING)
    @Column(name = "search")
    private Search search;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name= "height")
    private Integer height;

    public Profile() {
    }

    public Profile(Long id, String bio, List<String> image, Set<Temptation> temptation,
                   Search search, User user, Integer height) {
        this.id = id;
        this.bio = bio;
        this.image = image;
        this.temptation = temptation;
        this.search = search;
        this.user = user;
        this.height = height;
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

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
