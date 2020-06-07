package com.scoquix.deepIT.controller;

import com.scoquix.deepIT.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Date;

@RestController
public class LoginAPI {
    @PostMapping("/loginToken")
    public String get(@RequestBody User user) {
        // TODO: Sprawdz czy ten user jest w bazie danych !!!!
        long currentTimeInMillis = System.currentTimeMillis();
        String encodedString = Base64.getEncoder().encodeToString("aaa".getBytes());
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("username", user.getUsername())
                .claim("role", "ROLE_USER")
                .setIssuedAt(new Date(currentTimeInMillis))
                .setExpiration(new Date(currentTimeInMillis + 60_000))
                .signWith(SignatureAlgorithm.HS256, encodedString)
                .compact();
    }
}
