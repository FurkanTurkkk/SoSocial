package com.auth_service.auth_service.dto;

public class RegisterRequestDto {
    private String username;
    private String email;
    private String password;
    private String rePassword;

    public RegisterRequestDto(){}

    public RegisterRequestDto(String username, String email, String password, String rePassword) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.rePassword = rePassword;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRePassword() {
        return rePassword;
    }
}
