package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.net.URI;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    @SneakyThrows
    public ResponseEntity<User> registerUser(User user) {
        userRepository.save(user);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(user.getId()).toUri();

        ResponseCookie springCookie = ResponseCookie.from("username", user.getUsername())
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(60)
                .domain("localhost")
                .build();

//        return ResponseEntity.ok(user);
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, springCookie.toString()).body(user);
    }

    public ResponseEntity<User> loginUser(User user) {
        Optional<User> found = userRepository.findFirstByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (!found.isPresent()) {
            return ResponseEntity.badRequest().build();
        } else {
//            logging this user in
            ResponseCookie springCookie = ResponseCookie.from("username", user.getUsername())
                    .httpOnly(true)
                    .secure(false)
                    .path("/")
                    .maxAge(60)
                    .domain("localhost")
                    .build();
            return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, springCookie.toString()).body(found.get());
        }
    }
}
