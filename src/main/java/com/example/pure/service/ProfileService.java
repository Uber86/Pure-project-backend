package com.example.pure.service;

import com.example.pure.repository.ProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository repository;


    public ProfileService(ProfileRepository repository) {
        this.repository = repository;
    }


}
