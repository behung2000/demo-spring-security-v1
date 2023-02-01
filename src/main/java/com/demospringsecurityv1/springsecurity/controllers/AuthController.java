package com.demospringsecurityv1.springsecurity.controllers;

import com.demospringsecurityv1.springsecurity.jwt.JwtUtils;
import com.demospringsecurityv1.springsecurity.models.Role;
import com.demospringsecurityv1.springsecurity.models.User;
import com.demospringsecurityv1.springsecurity.models.UserDetailsImpl;
import com.demospringsecurityv1.springsecurity.repositories.RoleRepository;
import com.demospringsecurityv1.springsecurity.repositories.UserRepository;
import com.demospringsecurityv1.springsecurity.requests.LoginRequest;
import com.demospringsecurityv1.springsecurity.responses.JwtResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

@RestController
@RequestMapping("/spring-security/v1/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), roles));
    }

    /*
    @PutMapping("/account-admin")
    public ResponseEntity<?> authenticateCreatedAdmin() {
        User user = User.builder()
                .username("admin")
                .password(encoder.encode("Abcd1234"))
                .build();
        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findByRoleName("ROLE_ADMIN").orElseThrow(
                () -> new RuntimeException("Not Found")
        );
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
        return ResponseEntity.ok("Success created admin");
    }
     */
}
