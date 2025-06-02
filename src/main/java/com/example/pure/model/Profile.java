package com.example.pure.model;

import com.example.pure.dto.Temptation;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    private Long id;


    private String image;

    private String bio;

    private Temptation temptation;



}
