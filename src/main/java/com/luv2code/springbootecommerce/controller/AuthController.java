package com.luv2code.springbootecommerce.controller;

import com.luv2code.springbootecommerce.entity.Role;
import com.luv2code.springbootecommerce.entity.User;
import com.luv2code.springbootecommerce.payload.JWTAuthResponse;
import com.luv2code.springbootecommerce.payload.LoginDto;
import com.luv2code.springbootecommerce.payload.SignupDto;
import com.luv2code.springbootecommerce.repository.RoleRepository;
import com.luv2code.springbootecommerce.repository.UserRepository;
import com.luv2code.springbootecommerce.security.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    private PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @PostMapping("/login")
    private ResponseEntity<JWTAuthResponse> authenticateUser(@RequestBody LoginDto loginDto) {
        Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);



        // get token from tokenProvider
        String token = this.jwtTokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTAuthResponse(token));

    }

    @PostMapping("/signup")
    private ResponseEntity<?> registerUser(@RequestBody SignupDto signupDto) {

        if (this.userRepository.existsByUsername(signupDto.getUsername())) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        if (this.userRepository.existsByEmail(signupDto.getEmail())) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setName(signupDto.getName());
        user.setUsername(signupDto.getUsername());
        user.setEmail(signupDto.getEmail());
        user.setPassword(this.passwordEncoder().encode(signupDto.getPassword()));


        Role role = this.roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(role));

        this.userRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
}
