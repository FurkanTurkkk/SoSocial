package com.auth_service.auth_service.manager;

import com.auth_service.auth_service.dto.RequestForCreateUserProfile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-management",url = "http://localhost:9091/api/v1/user")
public interface UserProfileManager {
    @PostMapping
    void createUserProfile(@RequestBody RequestForCreateUserProfile request);

}
