package com.auth_service.auth_service.service;

import com.auth_service.auth_service.dto.LoginRequestDto;
import com.auth_service.auth_service.dto.RegisterRequestDto;
import com.auth_service.auth_service.dto.RequestForCreateUserProfile;
import com.auth_service.auth_service.exception.UserAlreadyExistException;
import com.auth_service.auth_service.manager.UserProfileManager;
import com.auth_service.auth_service.model.Auth;
import com.auth_service.auth_service.repostitory.AuthRepository;
import com.auth_service.auth_service.util.JwtUtil;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AuthService {

    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserProfileManager manager;

    public AuthService(AuthRepository authRepository, JwtUtil jwtUtil, UserProfileManager manager) {
        this.authRepository = authRepository;
        this.jwtUtil = jwtUtil;
        this.manager = manager;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }


    @Transactional
    public Auth register(RegisterRequestDto request) {

        if(!request.getPassword().equals(request.getRePassword())){
            throw new RuntimeException("The entered passwords must be the same.");
        }

        checkForExistToRegistration(request.getUsername(),request.getEmail());

        Auth auth = authRepository.save(new Auth(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                request.getEmail()
        ));

        manager.createUserProfile(new RequestForCreateUserProfile(auth.getUsername(),auth.getEmail(),auth.getId()));

        return auth;
    }

    public Object login(LoginRequestDto request) {
        Auth auth = getAuthByUsername(request.getUsername());
        if(!passwordEncoder.matches(request.getPassword(),auth.getPassword())){
            throw new RuntimeException("Password invalid");
        }
        return jwtUtil.generateToken(auth);
    }

    public Auth getAuthByUsername(String username){
        Optional<Auth> auth = authRepository.findByUsername(username);
        if(auth.isEmpty()){
            throw new UsernameNotFoundException("Username could not found : "+username);
        }
        return auth.get();
    }

    private void checkForExistToRegistration(String username, String email){
        if(authRepository.existsByEmail(email)) {
            throw new UserAlreadyExistException("User already exist by email : "+email);
        }
        if(authRepository.existsByUsername(username)) {
            throw new UserAlreadyExistException("User already exist by username : "+username);
        }
    }

}
