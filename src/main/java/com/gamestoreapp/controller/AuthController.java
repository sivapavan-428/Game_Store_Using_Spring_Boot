//package com.gamestoreapp.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.gamestoreapp.dto.LoginRequest;
//import com.gamestoreapp.dto.LoginResponse;
//import com.gamestoreapp.entity.User;
//import com.gamestoreapp.serviceImpl.AuthService;
//
//@RestController
//@RequestMapping("/auth")
//@CrossOrigin(origins = "http://localhost:3000")
//public class AuthController {
//
//    @Autowired
//    private AuthService authService;
//
//    @PostMapping("/signup")
//    public ResponseEntity<String> signup(@RequestBody User user){
//        User newUser = authService.registerUser(user);
//        return ResponseEntity.ok("User registered successfully with ID: " + newUser.getId());
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
//        LoginResponse response = authService.login(request);
//        return ResponseEntity.ok(response);
//    }
//}











package com.gamestoreapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamestoreapp.dto.LoginRequest;
import com.gamestoreapp.dto.LoginResponse;
import com.gamestoreapp.entity.User;
import com.gamestoreapp.security.JwtUtil;
import com.gamestoreapp.serviceImpl.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    // -------------------- Register user --------------------
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user){
        User newUser = authService.registerUser(user);
        return ResponseEntity.ok("User registered successfully with ID: " + newUser.getId());
    }

    // -------------------- Login user --------------------
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        LoginResponse response = authService.login(request);

        // Generate JWT using email + role
        String token = jwtUtil.generateToken(response.getEmail(), response.getRole());
        response.setToken(token);

        return ResponseEntity.ok(response);
    }

}
