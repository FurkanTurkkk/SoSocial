package com.user_service.user_service.service;

import com.user_service.user_service.converter.UserProfileDtoConverter;
import com.user_service.user_service.document.UserProfile;
import com.user_service.user_service.dto.RequestForCreateUserProfile;
import com.user_service.user_service.dto.RequestForUpdateUserProfile;
import com.user_service.user_service.exception.UnauthorizedException;
import com.user_service.user_service.exception.UserprofileNotFoundException;
import com.user_service.user_service.repository.UserProfileRepository;
import org.SocialMedia.UserProfileDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;
    private final UserProfileDtoConverter converter;

    public UserProfileService(UserProfileRepository userProfileRepository, UserProfileDtoConverter converter) {
        this.userProfileRepository = userProfileRepository;
        this.converter = converter;
    }

    public void createUserProfile(RequestForCreateUserProfile request) {
        userProfileRepository.save(new UserProfile(request.getAuthId(),request.getUsername(),request.getEmail()));
    }

    public UserProfileDto updateUserProfile(Long authId,RequestForUpdateUserProfile request){
        Optional<UserProfile> userProfile = userProfileRepository.findByAuthId(authId);
        if(userProfile.isPresent()){
            UserProfile existingUserProfile = userProfile.get();
            existingUserProfile.setName(request.getName());
            existingUserProfile.setLastname(request.getLastname());
            existingUserProfile.setPhone(request.getPhone());
            existingUserProfile.setInstagram(request.getInstagram());
            existingUserProfile.setTwitter(request.getTwitter());
            existingUserProfile.setAvatar(request.getAvatar());
            userProfileRepository.save(existingUserProfile);
            return converter.convert(existingUserProfile);
        }
        throw new UserprofileNotFoundException("User could not found");
    }

}
