package com.user_service.user_service.controller;

import com.user_service.user_service.dto.RequestForCreateUserProfile;
import com.user_service.user_service.dto.RequestForUpdateUserProfile;
import com.user_service.user_service.service.UserProfileService;
import org.SocialMedia.UserProfileDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping
    public void createUserProfile(@RequestBody RequestForCreateUserProfile request){
        userProfileService.createUserProfile(request);
    }

    @PutMapping
    public ResponseEntity<UserProfileDto> updateUserProfile(@RequestHeader("X-Auth-Id") Long authId,
                                                            @RequestBody RequestForUpdateUserProfile request){
        return ResponseEntity.ok(userProfileService.updateUserProfile(authId,request));
    }
}
