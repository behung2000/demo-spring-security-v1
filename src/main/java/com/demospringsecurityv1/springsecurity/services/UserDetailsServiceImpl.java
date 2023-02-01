package com.demospringsecurityv1.springsecurity.services;

import com.demospringsecurityv1.springsecurity.models.User;
import com.demospringsecurityv1.springsecurity.models.UserDetailsImpl;
import com.demospringsecurityv1.springsecurity.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findById(username).orElseThrow(
                () -> new RuntimeException("Not found")
        );
        return UserDetailsImpl.buildUser(user);
    }
}
