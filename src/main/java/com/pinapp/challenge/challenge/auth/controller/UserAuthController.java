package com.pinapp.challenge.challenge.auth.controller;

import com.pinapp.challenge.challenge.auth.dto.request.AuthenticationRequest;
import com.pinapp.challenge.challenge.auth.dto.request.UserDto;
import com.pinapp.challenge.challenge.auth.dto.response.AuthenticationResponse;
import com.pinapp.challenge.challenge.auth.service.SignInService;
import com.pinapp.challenge.challenge.auth.service.UserDetailsCustomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserAuthController {

    private final UserDetailsCustomService userDetailsCustomService;

    private final SignInService signInService;

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> signUp(@Valid @RequestBody UserDto user) throws Exception {
        userDetailsCustomService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn (@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        return signInService.signIn(authenticationRequest);
    }

}
