package com.example.challengealkemy.auth.filter;

import com.example.challengealkemy.auth.service.JwtUtil;
import com.example.challengealkemy.auth.service.UserDetailsCostomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtRequestFilter {

    @Autowired
    UserDetailsCostomService userDetailsCostomService;

    @Autowired
    JwtUtil jwtUtils;
    @Autowired
    AutehenticationManager autehenticationManager;

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, Filter chain){

        final String authorizationHeader = request.getHeader("Authorization");

        String userName = null;
        String jwt = null;

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            jwt = authorizationHeader.substring(7);
            userName = jwtUtils.extractUsername(jwt);
        }

        if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null){

            UserDetails userDetails = userDetailsCostomService.loadUserByUsername(userName);

            if(jwtUtils.validateToken(jwt, userDetails)){
                UsernamePasswordAuthenticationToken authenticationFilter =
                        new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword());
                Authentication auth = autehenticationManager.authenticate(authenticationFilter);
                //Set auth in context
                SecurityContextHolder.getContext().setAuthentication(auth);
            }

        }
        chain.doFilter(request,response);
    }
}
