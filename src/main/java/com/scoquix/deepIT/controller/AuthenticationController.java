package com.scoquix.deepIT.controller;

import com.scoquix.deepIT.dto.AuthUserDTO;
import com.scoquix.deepIT.entity.AuthorizedUser;
import com.scoquix.deepIT.services.AuthorizedUserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Date;
import java.util.logging.Logger;

@RestController
public class AuthenticationController {
    //    @Autowired
//    private UserDetailsManager userDetailsManager;
//
    @Autowired
    private AuthorizedUserService userService;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private Logger logger = Logger.getLogger(getClass().getName());


    @PostMapping("/loginToken")
    public String getAuthToken(@RequestBody AuthUserDTO user) {
        // check the database if user already exists
        boolean userExists = doesUserExist(user.getUsername());
        if (!userExists) {
            logger.warning("User name " + user.getUsername() + " doesn't exist.");
            return "User name " + user.getUsername() + "doesn't exist.";
        }

        boolean hasRoles = doesUserHasRoles(user);
        if (!hasRoles) {
            logger.warning("User name " + user.getUsername() + " doesn't have these role/roles.");
            return "User name " + user.getUsername() + " doesn't have these role/roles.";
        }

        long currentTimeInMillis = System.currentTimeMillis();
        String encodedString = Base64.getEncoder().encodeToString("aaa".getBytes());
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("username", user.getUsername())
                .claim("roles", user.getRoles())
                .setIssuedAt(new Date(currentTimeInMillis))
                .setExpiration(new Date(currentTimeInMillis + (60_000 * 5)))
                .signWith(SignatureAlgorithm.HS256, encodedString)
                .compact();
    }


    @PostMapping("/register")
    public HttpStatus registerUser(@RequestBody AuthorizedUser user) {
        boolean userExists = doesUserExist(user.getUsername());

        if (userExists) {
            logger.warning("User name already exists.");
            //return "User name already exists.";
            return HttpStatus.BAD_REQUEST;
        }
        // encrypt the password
        String encodedPassword = passwordEncoder.encode(user.getPassword().toString());

        // prepend the encoding algorithm id
        encodedPassword = "{bcrypt}" + encodedPassword;

        // give user default role of "employee"
        // List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");

        // create user object (from Spring Security framework)
        // User tempUser = new User(user.getUsername(), encodedPassword, authorities);
        AuthorizedUser temp = new AuthorizedUser(user.getUsername(), encodedPassword.toCharArray());
        temp.setEnabled(1);
        temp.addRole("ROLE_USER");
        // save user in the database
        // userDetailsManager.createUser(tempUser);
        userService.addUser(temp);
        return HttpStatus.CREATED;
    }

    private boolean doesUserExist(String userName) {

        logger.info("Checking if user exists: " + userName);
        // check the database if the user already exists
        //boolean exists = userDetailsManager.userExists(userName);
        boolean exists = userService.findById(userName).isPresent();

        logger.info("User: " + userName + ", exists: " + exists);

        return exists;
    }

    private boolean doesUserHasRoles(AuthUserDTO user) {
        AuthorizedUser authorizedUser = userService.findById(user.getUsername()).get();
        logger.info("DB roles: " + authorizedUser.getRoles().toString());
        logger.info("Given roles: " + user.getRoles().toString());
        return authorizedUser.getRoles().containsAll(user.getRoles());
    }
}
