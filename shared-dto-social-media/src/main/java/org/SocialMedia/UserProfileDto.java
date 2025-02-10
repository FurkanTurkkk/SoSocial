package org.SocialMedia;

public class UserProfileDto {
    private String username;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String avatar;
    private String instagram;
    private String twitter;

    public UserProfileDto(){}

    public UserProfileDto(String username, String name, String lastname, String email, String phone, String avatar, String instagram, String twitter) {
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.avatar = avatar;
        this.instagram = instagram;
        this.twitter = twitter;
    }

    public String getUsername() {
        return username;
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
