package com.uca.parcialfinalncapas.controller;

import com.uca.parcialfinalncapas.dto.auth.AuthRequest;
import com.uca.parcialfinalncapas.dto.auth.AuthResponse;
import com.uca.parcialfinalncapas.entities.User;
import com.uca.parcialfinalncapas.repository.UserRepository;
import com.uca.parcialfinalncapas.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        User user = userRepository.findByCorreo(request.getCorreo()).orElse(null);

        if (user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).body("Usuario o contraseña inválidos");
        }

        String token = jwtService.generateToken(user.getCorreo(), user.getNombreRol());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}

