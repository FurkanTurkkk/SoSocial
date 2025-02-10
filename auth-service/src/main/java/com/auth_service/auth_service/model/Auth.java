package com.auth_service.auth_service.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "auth")
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private Boolean isActive;
    private LocalDate createAt;

    public Auth(){
    }

    public Auth(String username,String password,String email){
        this.username = username;
        this.password = password;
        this.email = email;
        this.isActive = true;
        this.createAt = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
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
        Auth auth = (Auth) o;
        return Objects.equals(email, auth.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }
}
