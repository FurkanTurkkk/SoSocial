package com.user_service.user_service.document;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;

@Document
public class UserProfile {

    @Id
    private String id;

    private Long authId;
    private String username;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String avatar;
    private String instagram;
    private String twitter;
    private Boolean isActive;
    private LocalDate createAt;

    public UserProfile() {
    }

    public UserProfile(String username, String name, String lastname, String email, String phone) {
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.isActive = true;
        this.createAt = LocalDate.now();
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getId() {
        return id;
    }

    public Long getAuthId() {
        return authId;
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

    public Boolean getActive() {
        return isActive;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(email, that.email) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, phone);
    }

    public void updateEmail(String email){
        this.email = email;
    }

    public void updatePhone(String phone){
        this.phone = phone;
    }

    public void updateInstagram(String instagram){
        this.instagram = instagram;
    }

    public void updateTwitter(String twitter){
        this.twitter = twitter;
    }
}
