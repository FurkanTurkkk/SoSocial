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

    public UserProfile(Long authId, String username, String email) {
        this.authId = authId;
        this.username = username;
        this.email = email;
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

    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    public String getId() {
        return id;
    }

    public Long getAuthId() {
        return authId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setActive(Boolean active) {
        isActive = active;
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
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }

    public void updateEmail(String email){
        this.email = email;
    }

    public void updatePhone(String phone){
        this.phone = phone;
    }

}
