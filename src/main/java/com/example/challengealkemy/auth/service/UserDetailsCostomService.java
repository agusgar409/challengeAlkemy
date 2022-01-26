package com.example.challengealkemy.auth.service;

import com.example.challengealkemy.auth.entity.UserEntity;
import com.example.challengealkemy.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserName(userName);
        if(userEntity == null){
            throw  new UsernameNotFoundException("Username or password not found");
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
    }
}
