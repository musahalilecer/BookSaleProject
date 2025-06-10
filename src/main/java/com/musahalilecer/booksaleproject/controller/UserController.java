package com.musahalilecer.booksaleproject.controller;

import com.musahalilecer.booksaleproject.dto.request.UserRequest;
import com.musahalilecer.booksaleproject.model.User;
import com.musahalilecer.booksaleproject.repository.UserRepository;
import com.musahalilecer.booksaleproject.security.Role;
import com.musahalilecer.booksaleproject.service.serviceImp.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody UserRequest request){
        System.out.println("USERNAME: " + request.getUsername()); // 🔍 kontrol
        System.out.println("PASSWORD: " + request.getPassword());

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        User saved = userRepository.save(user);
        System.out.println("SAVED USER ID: " + saved.getId()); // ✅ boş gelirse sorun var

        String token = jwtService.createToken(new HashMap<>(), user.getUsername());
        return Map.of("token", token);
    }

    @PostMapping("/register-admin")
    public Map<String, String> registerAdmin(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.ADMIN);
        userRepository.save(user);

        String token = jwtService.createToken(Map.of("role", "ADMIN"), user.getUsername());
        return Map.of("token", token);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user){
        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
            User principal = (User) auth.getPrincipal();
        //    String token = jwtService.createToken(new HashMap<>(), principal.getUsername());
            String token = jwtService.createToken(Map.of("role", principal.getRole().name()), principal.getUsername());
            System.out.println("token: " + token);
            return Map.of("token", token);
        }
        catch (AuthenticationException e){
            throw new RuntimeException("Invalid Username or Password");
        }
    }
}
