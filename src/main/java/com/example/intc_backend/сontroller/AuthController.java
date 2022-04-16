package com.example.intc_backend.сontroller;

import com.example.intc_backend.config.JwtTokenService;
import com.example.intc_backend.config.JwtUserDetailsService;
import com.example.intc_backend.model.User;
import com.example.intc_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Map<String, String>> test(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        String type = body.get("type");
        UserDetails userDetails;
        try {
            userDetails = jwtUserDetailsService.loadUserByUsername(username);
        } catch (UsernameNotFoundException ex) {
            Map<String, String> error = Collections.singletonMap("error", "Token expired or user not found");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }

        String token = jwtTokenService.generateToken(userDetails);
        User user = userService.findByPhoneNumber(userDetails.getUsername());
        if (passwordEncoder.matches(password, user.getPassword()) && user.getType().equals(type)) {
            userService.updateToken(user.getId(), token);
            Map<String, String> result = Collections.singletonMap("token", token);
            return ResponseEntity.ok(result);
        }
        Map<String, String> error = Collections.singletonMap("error", "Password is NOT correct or TYPE user is not correct");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
