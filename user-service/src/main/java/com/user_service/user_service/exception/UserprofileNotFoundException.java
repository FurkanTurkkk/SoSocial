package com.user_service.user_service.exception;

public class UserprofileNotFoundException extends RuntimeException {
    public UserprofileNotFoundException(String userCouldNotFound) {
        super(userCouldNotFound);
    }
}
