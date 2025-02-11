package com.user_service.user_service.dto;

public class RequestForUpdateUserProfile {

    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String avatar;
    private String instagram;
    private String twitter;

    public RequestForUpdateUserProfile(){}

    public RequestForUpdateUserProfile(String name, String lastname, String email, String phone, String instagram, String twitter) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.instagram = instagram;
        this.twitter = twitter;
    }



    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getTwitter() {
        return twitter;
    }
}
