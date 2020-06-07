package com.scoquix.deepIT.controller;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.OAuth2Credentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.*;
import com.google.firebase.database.*;
import com.scoquix.deepIT.config.DataConfig;
import com.scoquix.deepIT.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

@RestController
public class AuthenticationController {

    @PostMapping("/loginToken")
    public String get(@RequestBody User user) {
            // TODO: Sprawdz czy ten user jest w bazie danych !!!
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
