package com.group2.online_book_store.Controller;

import com.group2.online_book_store.auth.AuthenticationRequest;
import com.group2.online_book_store.auth.AuthenticationResponse;
import com.group2.online_book_store.auth.AuthenticationService;
import com.group2.online_book_store.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor

public class AuthenticationController {
    private final AuthenticationService service;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        try {
            AuthenticationResponse response =service.register(request);
            return ResponseEntity.ok(response);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest request
    ){
       AuthenticationResponse response= service.authenticate(request);
       if (response == null) {
           return ResponseEntity.badRequest().build();
       }
        return ResponseEntity.ok(response);
    }
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return service.confirmToken(token);
    }
}
