package com.example.challengealkemy.auth.service;

import com.example.challengealkemy.auth.dto.AuthenticationRequest;
import com.example.challengealkemy.auth.dto.UserDTO;
import com.example.challengealkemy.auth.entity.UserEntity;
import com.example.challengealkemy.auth.repository.UserRepository;
import com.example.challengealkemy.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsCostomService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    EmailService emailService;
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if(userEntity == null){
            throw  new UsernameNotFoundException("Username or password not found");
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
    }

    public boolean save(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(userDTO.getPassword());
        //TODO: que se chequee que ya existe un usuario
        userEntity = userRepository.save(userEntity);
        if(userEntity != null){
            emailService.sendWelcomeEmailTo(userEntity.getUsername());
        }
        return userEntity != null;
    }


    //deberia ir aca?-----------------------------------------------------------------------------------
    public String authenticateUser(AuthenticationRequest authenticationRequest) throws Exception {
        UserDetails userDetails;
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
            );
            userDetails = (UserDetails) authentication.getPrincipal();
        }catch (BadCredentialsException ex){
            throw new Exception("Incorrect username or password",ex);
        }

        String jwt = jwtUtil.generateToken(userDetails);
        return jwt;
    }
    //deberia ir aca?-----------------------------------------------------------------------------------
}
