package com.user_service.user_service.converter;

import com.user_service.user_service.document.UserProfile;
import org.SocialMedia.UserProfileDto;
import org.springframework.stereotype.Component;

@Component
public class UserProfileDtoConverter {

    public UserProfileDto convert(UserProfile from){
        return new UserProfileDto(
                from.getUsername(),
                from.getName(),
                from.getLastname(),
                from.getEmail(),
                from.getPhone(),
                from.getAvatar(),
                from.getInstagram(),
                from.getTwitter()
        );
    }
}
