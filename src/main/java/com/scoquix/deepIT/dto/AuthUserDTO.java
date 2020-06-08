package com.scoquix.deepIT.dto;

import javax.persistence.Entity;
import java.util.Arrays;
import java.util.List;

@Entity
public class AuthUserDTO {
    private String username;
    private char[] password;
    private List<String> roles;

    public AuthUserDTO(String username, char[] password, List<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public AuthUserDTO() {
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthUserDTO{" +
                "username='" + username + '\'' +
                ", password=" + Arrays.toString(password) +
                ", roles=" + roles +
                '}';
    }
}

