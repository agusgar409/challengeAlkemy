package com.example.challengealkemy.auth.controller;

import com.example.challengealkemy.auth.dto.AuthenticationRequest;
import com.example.challengealkemy.auth.dto.AuthenticationResponse;
import com.example.challengealkemy.auth.dto.UserDTO;
import com.example.challengealkemy.auth.entity.UserEntity;
import com.example.challengealkemy.auth.service.JwtUtil;
import com.example.challengealkemy.auth.service.UserDetailsCostomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class UserAuthController {

    @Autowired
    UserDetailsCostomService userDetailsCostomService;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/singup")
    public ResponseEntity<Object> singUp(@Valid @RequestBody UserDTO userDTO) throws Exception{
        userDetailsCostomService.save(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/singin")
    public ResponseEntity<AuthenticationResponse> singIn(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        UserDetails userDetails = userDetailsCostomService.authenticateUser(authenticationRequest);
        return ResponseEntity.ok(new AuthenticationResponse(jwtUtil.generateToken(userDetails)));
    }
}
