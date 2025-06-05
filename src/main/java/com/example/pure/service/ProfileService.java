package com.example.pure.service;

import com.example.pure.dto.ProfileDto;
import com.example.pure.mapper.ProfileMapper;
import com.example.pure.model.Profile;
import com.example.pure.repository.ProfileRepository;
import com.example.pure.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileMapper professionMapper;
    private final UserRepository userRepository;
    private final SecurityService securityService;

    public ProfileService(ProfileRepository profileRepository,
                          ProfileMapper professionMapper,
                          UserRepository userRepository,
                          SecurityService securityService) {
        this.profileRepository = profileRepository;
        this.professionMapper = professionMapper;
        this.userRepository = userRepository;
        this.securityService = securityService;
    }

    public ProfileDto getMyProfile() {
        Long userId = securityService.getCurrentUserId();
        Profile profile = profileRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Profile not found"));
        return professionMapper.toDto(profile);
    }

    public ProfileDto updateMyProfile(ProfileDto dto) {
        Long userId = securityService.getCurrentUserId();
        Profile profile = profileRepository.findByUserId(userId).orElse(new Profile());
        profile.setBio(dto.getBio());
        profile.setHeight(dto.getHeight());
        profile.setImage(dto.getImage());
        profile.setTemptation(dto.getTemptation());
        profile.setSearch(dto.getSearch());
        profile.setUser(userRepository.findById(userId).orElseThrow());
        return professionMapper.toDto(profileRepository.save(profile));
    }
}
