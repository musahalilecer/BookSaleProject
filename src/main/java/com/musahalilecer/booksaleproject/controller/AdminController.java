package com.musahalilecer.booksaleproject.controller;

import com.musahalilecer.booksaleproject.model.User;
import com.musahalilecer.booksaleproject.repository.UserRepository;
import com.musahalilecer.booksaleproject.security.Role;
import com.musahalilecer.booksaleproject.service.serviceImp.JwtService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AdminController {

}
