package com.auth_service.auth_service.dto;

public class RequestForCreateUserProfile {
    private String username;
    private String email;
    private Long authId;

    public RequestForCreateUserProfile(){
    }

    public RequestForCreateUserProfile(String username, String email, Long authId) {
        this.username = username;
        this.email = email;
        this.authId = authId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Long getAuthId() {
        return authId;
    }
}
